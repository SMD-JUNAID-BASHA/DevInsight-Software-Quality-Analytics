package com.junaid.devinsight.analytics;

import com.junaid.devinsight.entity.Build;
import com.junaid.devinsight.entity.Defect;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.entity.TestCase;
import com.junaid.devinsight.repository.BuildRepository;
import com.junaid.devinsight.repository.DefectRepository;
import com.junaid.devinsight.repository.ProjectRepository;
import com.junaid.devinsight.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {

    private final TestCaseRepository testCaseRepository;
    private final DefectRepository defectRepository;
    private final BuildRepository buildRepository;
    private final ProjectRepository projectRepository;

    public AnalyticsService(
            TestCaseRepository testCaseRepository,
            DefectRepository defectRepository,
            BuildRepository buildRepository,
            ProjectRepository projectRepository) {

        this.testCaseRepository = testCaseRepository;
        this.defectRepository = defectRepository;
        this.buildRepository = buildRepository;
        this.projectRepository = projectRepository;
    }

    public QualityMetrics calculateQualityMetrics() {

        QualityMetrics metrics = new QualityMetrics();

        List<TestCase> testCases = testCaseRepository.findAll();

        long totalTestCases = testCases.size();

        long passedTestCases = testCases.stream()
                .filter(testCase ->
                        "PASSED".equalsIgnoreCase(testCase.getStatus()))
                .count();

        long failedTestCases = testCases.stream()
                .filter(testCase ->
                        "FAILED".equalsIgnoreCase(testCase.getStatus()))
                .count();

        double testPassRate = totalTestCases == 0
                ? 0
                : (passedTestCases * 100.0) / totalTestCases;

        metrics.setTotalTestCases(totalTestCases);
        metrics.setPassedTestCases(passedTestCases);
        metrics.setFailedTestCases(failedTestCases);
        metrics.setTestPassRate(testPassRate);

        List<Defect> defects = defectRepository.findAll();

        long totalDefects = defects.size();

        long openDefects = defects.stream()
                .filter(defect ->
                        "OPEN".equalsIgnoreCase(defect.getStatus()))
                .count();

        long resolvedDefects = defects.stream()
                .filter(defect ->
                        "RESOLVED".equalsIgnoreCase(defect.getStatus()))
                .count();

        long closedDefects = defects.stream()
                .filter(defect ->
                        "CLOSED".equalsIgnoreCase(defect.getStatus()))
                .count();

        List<Defect> resolvedDefectsWithTimestamps = defects.stream()
                .filter(defect ->
                        defect.getCreatedAt() != null
                                && defect.getResolvedAt() != null)
                .toList();

        double averageDefectResolutionHours =
                resolvedDefectsWithTimestamps.isEmpty()
                        ? 0
                        : resolvedDefectsWithTimestamps.stream()
                        .mapToLong(defect ->
                                Duration.between(
                                        defect.getCreatedAt(),
                                        defect.getResolvedAt()
                                ).toMinutes()
                        )
                        .average()
                        .orElse(0) / 60.0;

        metrics.setTotalDefects(totalDefects);
        metrics.setOpenDefects(openDefects);
        metrics.setResolvedDefects(resolvedDefects);
        metrics.setClosedDefects(closedDefects);
        metrics.setAverageDefectResolutionHours(
                averageDefectResolutionHours
        );

        List<Build> builds = buildRepository.findAll();

        long totalBuilds = builds.size();

        long successfulBuilds = builds.stream()
                .filter(build ->
                        "SUCCESS".equalsIgnoreCase(build.getStatus()))
                .count();

        long failedBuilds = builds.stream()
                .filter(build ->
                        "FAILED".equalsIgnoreCase(build.getStatus()))
                .count();

        double buildSuccessRate = totalBuilds == 0
                ? 0
                : (successfulBuilds * 100.0) / totalBuilds;

        metrics.setTotalBuilds(totalBuilds);
        metrics.setSuccessfulBuilds(successfulBuilds);
        metrics.setFailedBuilds(failedBuilds);
        metrics.setBuildSuccessRate(buildSuccessRate);

        return metrics;
    }

    public List<ProjectQualityMetrics> calculateProjectQualityMetrics() {

        List<Project> projects = projectRepository.findAll();
        List<TestCase> testCases = testCaseRepository.findAll();
        List<Defect> defects = defectRepository.findAll();
        List<Build> builds = buildRepository.findAll();

        List<ProjectQualityMetrics> projectMetrics = new ArrayList<>();

        for (Project project : projects) {

            Long projectId = project.getId();

            List<TestCase> projectTestCases = testCases.stream()
                    .filter(testCase ->
                            testCase.getProject() != null
                                    && projectId.equals(
                                    testCase.getProject().getId()))
                    .toList();

            long totalTestCases = projectTestCases.size();

            long passedTestCases = projectTestCases.stream()
                    .filter(testCase ->
                            "PASSED".equalsIgnoreCase(
                                    testCase.getStatus()))
                    .count();

            long failedTestCases = projectTestCases.stream()
                    .filter(testCase ->
                            "FAILED".equalsIgnoreCase(
                                    testCase.getStatus()))
                    .count();

            double testPassRate = totalTestCases == 0
                    ? 0
                    : (passedTestCases * 100.0) / totalTestCases;

            List<Defect> projectDefects = defects.stream()
                    .filter(defect ->
                            defect.getProject() != null
                                    && projectId.equals(
                                    defect.getProject().getId()))
                    .toList();

            long totalDefects = projectDefects.size();

            long openDefects = projectDefects.stream()
                    .filter(defect ->
                            "OPEN".equalsIgnoreCase(
                                    defect.getStatus()))
                    .count();

            long resolvedDefects = projectDefects.stream()
                    .filter(defect ->
                            "RESOLVED".equalsIgnoreCase(
                                    defect.getStatus()))
                    .count();

            long closedDefects = projectDefects.stream()
                    .filter(defect ->
                            "CLOSED".equalsIgnoreCase(
                                    defect.getStatus()))
                    .count();

            List<Defect> projectResolvedDefectsWithTimestamps =
                    projectDefects.stream()
                            .filter(defect ->
                                    defect.getCreatedAt() != null
                                            && defect.getResolvedAt() != null)
                            .toList();

            double averageDefectResolutionHours =
                    projectResolvedDefectsWithTimestamps.isEmpty()
                            ? 0
                            : projectResolvedDefectsWithTimestamps.stream()
                            .mapToLong(defect ->
                                    Duration.between(
                                            defect.getCreatedAt(),
                                            defect.getResolvedAt()
                                    ).toMinutes()
                            )
                            .average()
                            .orElse(0) / 60.0;

            List<Build> projectBuilds = builds.stream()
                    .filter(build ->
                            build.getProject() != null
                                    && projectId.equals(
                                    build.getProject().getId()))
                    .toList();

            long totalBuilds = projectBuilds.size();

            long successfulBuilds = projectBuilds.stream()
                    .filter(build ->
                            "SUCCESS".equalsIgnoreCase(
                                    build.getStatus()))
                    .count();

            long failedBuilds = projectBuilds.stream()
                    .filter(build ->
                            "FAILED".equalsIgnoreCase(
                                    build.getStatus()))
                    .count();

            double buildSuccessRate = totalBuilds == 0
                    ? 0
                    : (successfulBuilds * 100.0) / totalBuilds;

            ProjectQualityMetrics metrics =
                    new ProjectQualityMetrics();

            metrics.setProjectId(projectId);
            metrics.setProjectName(project.getName());

            metrics.setTotalTestCases(totalTestCases);
            metrics.setPassedTestCases(passedTestCases);
            metrics.setFailedTestCases(failedTestCases);
            metrics.setTestPassRate(testPassRate);

            metrics.setTotalDefects(totalDefects);
            metrics.setOpenDefects(openDefects);
            metrics.setResolvedDefects(resolvedDefects);
            metrics.setClosedDefects(closedDefects);
            metrics.setAverageDefectResolutionHours(
                    averageDefectResolutionHours
            );

            metrics.setTotalBuilds(totalBuilds);
            metrics.setSuccessfulBuilds(successfulBuilds);
            metrics.setFailedBuilds(failedBuilds);
            metrics.setBuildSuccessRate(buildSuccessRate);

            projectMetrics.add(metrics);
        }

        return projectMetrics;
    }
}