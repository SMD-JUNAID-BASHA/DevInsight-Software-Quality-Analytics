package com.junaid.devinsight.service;

import com.junaid.devinsight.dto.DefectRequest;
import com.junaid.devinsight.dto.DefectResponse;
import com.junaid.devinsight.entity.Defect;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.repository.DefectRepository;
import com.junaid.devinsight.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectService {

    private final DefectRepository defectRepository;
    private final ProjectRepository projectRepository;

    public DefectService(
            DefectRepository defectRepository,
            ProjectRepository projectRepository) {

        this.defectRepository = defectRepository;
        this.projectRepository = projectRepository;
    }

    public List<DefectResponse> getAllDefects() {

        return defectRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public DefectResponse getDefectById(Long id) {

        return defectRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Defect not found with id: " + id
                        ));
    }

    public DefectResponse createDefect(DefectRequest request) {

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project not found with id: "
                                        + request.getProjectId()
                        ));

        Defect defect = new Defect();

        defect.setTitle(request.getTitle());
        defect.setDescription(request.getDescription());
        defect.setSeverity(request.getSeverity());
        defect.setStatus(request.getStatus());
        defect.setProject(project);

        Defect savedDefect = defectRepository.save(defect);

        return convertToResponse(savedDefect);
    }

    public DefectResponse updateDefect(
            Long id,
            DefectRequest request) {

        return defectRepository.findById(id)
                .map(defect -> {

                    Project project =
                            projectRepository.findById(request.getProjectId())
                                    .orElseThrow(() ->
                                            new RuntimeException(
                                                    "Project not found with id: "
                                                            + request.getProjectId()
                                            ));

                    defect.setTitle(request.getTitle());
                    defect.setDescription(request.getDescription());
                    defect.setSeverity(request.getSeverity());
                    defect.setStatus(request.getStatus());
                    defect.setProject(project);

                    Defect updatedDefect =
                            defectRepository.save(defect);

                    return convertToResponse(updatedDefect);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Defect not found with id: " + id
                        ));
    }

    public void deleteDefect(Long id) {

        if (!defectRepository.existsById(id)) {
            throw new RuntimeException(
                    "Defect not found with id: " + id
            );
        }

        defectRepository.deleteById(id);
    }

    private DefectResponse convertToResponse(Defect defect) {

        return new DefectResponse(
                defect.getId(),
                defect.getTitle(),
                defect.getDescription(),
                defect.getSeverity(),
                defect.getStatus(),
                defect.getProject().getId(),
                defect.getCreatedAt(),
                defect.getResolvedAt()
        );
    }
}