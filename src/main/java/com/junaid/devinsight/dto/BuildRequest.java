package com.junaid.devinsight.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class BuildRequest {

    @NotBlank(message = "Build number is required")
    private String buildNumber;

    @NotBlank(message = "Build status is required")
    private String status;

    @NotNull(message = "Build duration is required")
    @PositiveOrZero(message = "Build duration cannot be negative")
    private Integer durationSeconds;

    @NotNull(message = "Project ID is required")
    private Long projectId;

    public BuildRequest() {
    }

    public BuildRequest(
            String buildNumber,
            String status,
            Integer durationSeconds,
            Long projectId) {

        this.buildNumber = buildNumber;
        this.status = status;
        this.durationSeconds = durationSeconds;
        this.projectId = projectId;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}