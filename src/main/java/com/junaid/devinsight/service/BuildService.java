package com.junaid.devinsight.service;

import com.junaid.devinsight.dto.BuildRequest;
import com.junaid.devinsight.dto.BuildResponse;
import com.junaid.devinsight.entity.Build;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.repository.BuildRepository;
import com.junaid.devinsight.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildService {

    private final BuildRepository buildRepository;
    private final ProjectRepository projectRepository;

    public BuildService(
            BuildRepository buildRepository,
            ProjectRepository projectRepository) {

        this.buildRepository = buildRepository;
        this.projectRepository = projectRepository;
    }

    public List<BuildResponse> getAllBuilds() {

        return buildRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public BuildResponse getBuildById(Long id) {

        return buildRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Build not found with id: " + id
                        ));
    }

    public BuildResponse createBuild(BuildRequest request) {

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project not found with id: "
                                        + request.getProjectId()
                        ));

        Build build = new Build();

        build.setBuildNumber(request.getBuildNumber());
        build.setStatus(request.getStatus());
        build.setDurationSeconds(request.getDurationSeconds());
        build.setProject(project);

        Build savedBuild = buildRepository.save(build);

        return convertToResponse(savedBuild);
    }

    public BuildResponse updateBuild(
            Long id,
            BuildRequest request) {

        return buildRepository.findById(id)
                .map(build -> {

                    Project project =
                            projectRepository.findById(request.getProjectId())
                                    .orElseThrow(() ->
                                            new RuntimeException(
                                                    "Project not found with id: "
                                                            + request.getProjectId()
                                            ));

                    build.setBuildNumber(request.getBuildNumber());
                    build.setStatus(request.getStatus());
                    build.setDurationSeconds(request.getDurationSeconds());
                    build.setProject(project);

                    Build updatedBuild =
                            buildRepository.save(build);

                    return convertToResponse(updatedBuild);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Build not found with id: " + id
                        ));
    }

    public void deleteBuild(Long id) {

        if (!buildRepository.existsById(id)) {
            throw new RuntimeException(
                    "Build not found with id: " + id
            );
        }

        buildRepository.deleteById(id);
    }

    private BuildResponse convertToResponse(Build build) {

        return new BuildResponse(
                build.getId(),
                build.getBuildNumber(),
                build.getStatus(),
                build.getDurationSeconds(),
                build.getProject().getId()
        );
    }
}