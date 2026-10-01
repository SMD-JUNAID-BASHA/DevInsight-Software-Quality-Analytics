package com.junaid.devinsight.analytics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/quality")
    public ResponseEntity<QualityMetrics> getQualityMetrics() {
        return ResponseEntity.ok(analyticsService.calculateQualityMetrics());
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectQualityMetrics>> getProjectQualityMetrics() {
        return ResponseEntity.ok(
                analyticsService.calculateProjectQualityMetrics()
        );
    }
}