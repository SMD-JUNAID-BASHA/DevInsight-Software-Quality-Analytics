package com.junaid.devinsight.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectRequest {

    @NotBlank(message = "Project name is required")
    private String name;

    @NotBlank(message = "Project description is required")
    private String description;

    @NotBlank(message = "Technology is required")
    private String technology;

    @NotBlank(message = "Project status is required")
    private String status;

    public ProjectRequest() {
    }

    public ProjectRequest(
            String name,
            String description,
            String technology,
            String status) {

        this.name = name;
        this.description = description;
        this.technology = technology;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}