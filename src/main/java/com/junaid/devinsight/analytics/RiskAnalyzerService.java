package com.junaid.devinsight.analytics;

import org.springframework.stereotype.Service;

@Service
public class RiskAnalyzerService {

    private final AnalyticsService analyticsService;

    public RiskAnalyzerService(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    public RiskAssessment analyzeRisk() {

        QualityMetrics metrics = analyticsService.calculateQualityMetrics();

        int riskScore = 0;


        if (metrics.getTestPassRate() < 70) {
            riskScore += 30;
        } else if (metrics.getTestPassRate() < 85) {
            riskScore += 15;
        }


        if (metrics.getBuildSuccessRate() < 70) {
            riskScore += 30;
        } else if (metrics.getBuildSuccessRate() < 85) {
            riskScore += 15;
        }


        if (metrics.getOpenDefects() >= 5) {
            riskScore += 30;
        } else if (metrics.getOpenDefects() >= 2) {
            riskScore += 15;
        }


        String riskLevel;

        if (riskScore >= 60) {
            riskLevel = "HIGH";
        } else if (riskScore >= 30) {
            riskLevel = "MEDIUM";
        } else {
            riskLevel = "LOW";
        }


        String recommendation;

        if ("HIGH".equals(riskLevel)) {
            recommendation = "Immediate attention required. Investigate failed tests, failed builds and open defects.";
        } else if ("MEDIUM".equals(riskLevel)) {
            recommendation = "Improve test coverage, monitor build failures and resolve open defects.";
        } else {
            recommendation = "Quality indicators are currently stable. Continue monitoring project metrics.";
        }

        return new RiskAssessment(
                riskLevel,
                riskScore,
                recommendation
        );
    }
}