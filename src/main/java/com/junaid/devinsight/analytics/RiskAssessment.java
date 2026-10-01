package com.junaid.devinsight.analytics;

public class RiskAssessment {

    private String riskLevel;
    private int riskScore;
    private String recommendation;

    public RiskAssessment() {
    }

    public RiskAssessment(String riskLevel, int riskScore, String recommendation) {
        this.riskLevel = riskLevel;
        this.riskScore = riskScore;
        this.recommendation = recommendation;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}