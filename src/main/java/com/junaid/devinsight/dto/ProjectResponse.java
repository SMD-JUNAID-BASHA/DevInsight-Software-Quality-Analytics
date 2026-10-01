package com.junaid.devinsight.dto;

public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private String technology;
    private String status;

    public ProjectResponse() {
    }

    public ProjectResponse(
            Long id,
            String name,
            String description,
            String technology,
            String status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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