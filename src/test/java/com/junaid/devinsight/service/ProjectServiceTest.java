package com.junaid.devinsight.service;

import com.junaid.devinsight.dto.ProjectRequest;
import com.junaid.devinsight.dto.ProjectResponse;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    void createProject_shouldCreateProjectSuccessfully() {

        ProjectRequest request = new ProjectRequest(
                "DevInsight",
                "Software Quality and Data Analytics Platform",
                "Java Spring Boot",
                "ACTIVE"
        );

        Project savedProject = new Project(
                "DevInsight",
                "Software Quality and Data Analytics Platform",
                "Java Spring Boot",
                "ACTIVE"
        );

        when(projectRepository.save(any(Project.class)))
                .thenReturn(savedProject);

        ProjectResponse response = projectService.createProject(request);

        assertNotNull(response);
        assertEquals("DevInsight", response.getName());
        assertEquals(
                "Software Quality and Data Analytics Platform",
                response.getDescription()
        );
        assertEquals("Java Spring Boot", response.getTechnology());
        assertEquals("ACTIVE", response.getStatus());

        verify(projectRepository, times(1))
                .save(any(Project.class));
    }

    @Test
    void getProjectById_shouldReturnProjectSuccessfully() {

        Project project = new Project(
                "DevInsight",
                "Software Quality and Data Analytics Platform",
                "Java Spring Boot",
                "ACTIVE"
        );

        when(projectRepository.findById(1L))
                .thenReturn(Optional.of(project));

        ProjectResponse response = projectService.getProjectById(1L);

        assertNotNull(response);
        assertEquals("DevInsight", response.getName());
        assertEquals(
                "Software Quality and Data Analytics Platform",
                response.getDescription()
        );
        assertEquals("Java Spring Boot", response.getTechnology());
        assertEquals("ACTIVE", response.getStatus());

        verify(projectRepository, times(1))
                .findById(1L);
    }

    @Test
    void getProjectById_shouldThrowExceptionWhenProjectNotFound() {

        when(projectRepository.findById(999L))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> projectService.getProjectById(999L)
        );

        assertEquals(
                "Project not found with id: 999",
                exception.getMessage()
        );

        verify(projectRepository, times(1))
                .findById(999L);
    }
}