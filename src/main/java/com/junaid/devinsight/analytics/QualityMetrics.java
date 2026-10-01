package com.junaid.devinsight.analytics;

public class QualityMetrics {

    private long totalTestCases;
    private long passedTestCases;
    private long failedTestCases;
    private double testPassRate;

    private long totalDefects;
    private long openDefects;
    private long resolvedDefects;
    private long closedDefects;
    private double averageDefectResolutionHours;

    private long totalBuilds;
    private long successfulBuilds;
    private long failedBuilds;
    private double buildSuccessRate;

    public QualityMetrics() {
    }

    public long getTotalTestCases() {
        return totalTestCases;
    }

    public void setTotalTestCases(long totalTestCases) {
        this.totalTestCases = totalTestCases;
    }

    public long getPassedTestCases() {
        return passedTestCases;
    }

    public void setPassedTestCases(long passedTestCases) {
        this.passedTestCases = passedTestCases;
    }

    public long getFailedTestCases() {
        return failedTestCases;
    }

    public void setFailedTestCases(long failedTestCases) {
        this.failedTestCases = failedTestCases;
    }

    public double getTestPassRate() {
        return testPassRate;
    }

    public void setTestPassRate(double testPassRate) {
        this.testPassRate = testPassRate;
    }

    public long getTotalDefects() {
        return totalDefects;
    }

    public void setTotalDefects(long totalDefects) {
        this.totalDefects = totalDefects;
    }

    public long getOpenDefects() {
        return openDefects;
    }

    public void setOpenDefects(long openDefects) {
        this.openDefects = openDefects;
    }

    public long getResolvedDefects() {
        return resolvedDefects;
    }

    public void setResolvedDefects(long resolvedDefects) {
        this.resolvedDefects = resolvedDefects;
    }

    public long getClosedDefects() {
        return closedDefects;
    }

    public void setClosedDefects(long closedDefects) {
        this.closedDefects = closedDefects;
    }

    public double getAverageDefectResolutionHours() {
        return averageDefectResolutionHours;
    }

    public void setAverageDefectResolutionHours(
            double averageDefectResolutionHours) {

        this.averageDefectResolutionHours =
                averageDefectResolutionHours;
    }

    public long getTotalBuilds() {
        return totalBuilds;
    }

    public void setTotalBuilds(long totalBuilds) {
        this.totalBuilds = totalBuilds;
    }

    public long getSuccessfulBuilds() {
        return successfulBuilds;
    }

    public void setSuccessfulBuilds(long successfulBuilds) {
        this.successfulBuilds = successfulBuilds;
    }

    public long getFailedBuilds() {
        return failedBuilds;
    }

    public void setFailedBuilds(long failedBuilds) {
        this.failedBuilds = failedBuilds;
    }

    public double getBuildSuccessRate() {
        return buildSuccessRate;
    }

    public void setBuildSuccessRate(double buildSuccessRate) {
        this.buildSuccessRate = buildSuccessRate;
    }
}