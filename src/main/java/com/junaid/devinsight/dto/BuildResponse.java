package com.junaid.devinsight.dto;

public class BuildResponse {

    private Long id;
    private String buildNumber;
    private String status;
    private Integer durationSeconds;
    private Long projectId;

    public BuildResponse() {
    }

    public BuildResponse(
            Long id,
            String buildNumber,
            String status,
            Integer durationSeconds,
            Long projectId) {

        this.id = id;
        this.buildNumber = buildNumber;
        this.status = status;
        this.durationSeconds = durationSeconds;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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