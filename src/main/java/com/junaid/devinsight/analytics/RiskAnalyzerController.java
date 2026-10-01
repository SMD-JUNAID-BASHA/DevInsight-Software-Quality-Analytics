package com.junaid.devinsight.analytics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class RiskAnalyzerController {

    private final RiskAnalyzerService riskAnalyzerService;

    public RiskAnalyzerController(RiskAnalyzerService riskAnalyzerService) {
        this.riskAnalyzerService = riskAnalyzerService;
    }

    @GetMapping("/risk")
    public ResponseEntity<RiskAssessment> analyzeRisk() {
        return ResponseEntity.ok(riskAnalyzerService.analyzeRisk());
    }
}