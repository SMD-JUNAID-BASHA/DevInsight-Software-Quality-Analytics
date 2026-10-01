package com.junaid.devinsight.service;

import com.junaid.devinsight.dto.ProjectRequest;
import com.junaid.devinsight.dto.ProjectResponse;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public ProjectResponse getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() ->
                        new RuntimeException("Project not found with id: " + id));
    }

    public ProjectResponse createProject(ProjectRequest request) {

        Project project = new Project();

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setTechnology(request.getTechnology());
        project.setStatus(request.getStatus());

        Project savedProject = projectRepository.save(project);

        return convertToResponse(savedProject);
    }

    public ProjectResponse updateProject(Long id, ProjectRequest request) {

        return projectRepository.findById(id)
                .map(project -> {

                    project.setName(request.getName());
                    project.setDescription(request.getDescription());
                    project.setTechnology(request.getTechnology());
                    project.setStatus(request.getStatus());

                    Project updatedProject = projectRepository.save(project);

                    return convertToResponse(updatedProject);
                })
                .orElseThrow(() ->
                        new RuntimeException("Project not found with id: " + id));
    }

    public void deleteProject(Long id) {

        if (!projectRepository.existsById(id)) {
            throw new RuntimeException(
                    "Project not found with id: " + id
            );
        }

        projectRepository.deleteById(id);
    }

    private ProjectResponse convertToResponse(Project project) {

        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getTechnology(),
                project.getStatus()
        );
    }
}