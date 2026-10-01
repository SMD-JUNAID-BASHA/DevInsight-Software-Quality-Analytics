package com.junaid.devinsight.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "builds")
public class Build {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Build number is required")
    private String buildNumber;

    @NotBlank(message = "Build status is required")
    private String status;

    @NotNull(message = "Build duration is required")
    @PositiveOrZero(message = "Build duration cannot be negative")
    private Integer durationSeconds;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Build() {
    }

    public Build(
            String buildNumber,
            String status,
            Integer durationSeconds,
            Project project) {

        this.buildNumber = buildNumber;
        this.status = status;
        this.durationSeconds = durationSeconds;
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}