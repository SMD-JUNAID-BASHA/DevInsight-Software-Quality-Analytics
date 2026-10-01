package com.junaid.devinsight.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DefectRequest {

    @NotBlank(message = "Defect title is required")
    private String title;

    @NotBlank(message = "Defect description is required")
    private String description;

    @NotBlank(message = "Defect severity is required")
    private String severity;

    @NotBlank(message = "Defect status is required")
    private String status;

    @NotNull(message = "Project ID is required")
    private Long projectId;

    public DefectRequest() {
    }

    public DefectRequest(
            String title,
            String description,
            String severity,
            String status,
            Long projectId) {

        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}