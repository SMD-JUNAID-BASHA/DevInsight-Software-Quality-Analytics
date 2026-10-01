package com.junaid.devinsight.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TestCaseRequest {

    @NotBlank(message = "Test case name is required")
    private String testCaseName;

    @NotBlank(message = "Test case description is required")
    private String description;

    @NotBlank(message = "Test case status is required")
    private String status;

    @NotBlank(message = "Test case priority is required")
    private String priority;

    @NotNull(message = "Project ID is required")
    private Long projectId;

    public TestCaseRequest() {
    }

    public TestCaseRequest(
            String testCaseName,
            String description,
            String status,
            String priority,
            Long projectId) {

        this.testCaseName = testCaseName;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.projectId = projectId;
    }

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}