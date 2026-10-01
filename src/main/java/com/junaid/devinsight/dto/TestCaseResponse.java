package com.junaid.devinsight.dto;

public class TestCaseResponse {

    private Long id;
    private String testCaseName;
    private String description;
    private String status;
    private String priority;
    private Long projectId;

    public TestCaseResponse() {
    }

    public TestCaseResponse(
            Long id,
            String testCaseName,
            String description,
            String status,
            String priority,
            Long projectId) {

        this.id = id;
        this.testCaseName = testCaseName;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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