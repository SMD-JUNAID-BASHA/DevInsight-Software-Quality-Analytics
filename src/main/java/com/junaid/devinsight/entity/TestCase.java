package com.junaid.devinsight.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "test_cases")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Test case name is required")
    private String testCaseName;

    @NotBlank(message = "Test case description is required")
    private String description;

    @NotBlank(message = "Test case status is required")
    private String status;

    @NotBlank(message = "Test case priority is required")
    private String priority;

    @NotNull(message = "Project is required")
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public TestCase() {
    }

    public TestCase(
            String testCaseName,
            String description,
            String status,
            String priority,
            Project project) {

        this.testCaseName = testCaseName;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}