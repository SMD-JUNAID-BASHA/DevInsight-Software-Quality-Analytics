package com.junaid.devinsight.service;

import com.junaid.devinsight.dto.DefectRequest;
import com.junaid.devinsight.dto.DefectResponse;
import com.junaid.devinsight.entity.Defect;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.repository.DefectRepository;
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
class DefectServiceTest {

    @Mock
    private DefectRepository defectRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private DefectService defectService;

    @Test
    void createDefect_shouldCreateDefectSuccessfully() {

        Project project = new Project(
                "DevInsight",
                "Software Quality and Data Analytics Platform",
                "Java Spring Boot",
                "ACTIVE"
        );

        DefectRequest request = new DefectRequest(
                "Login failure",
                "User cannot login with valid credentials",
                "HIGH",
                "OPEN",
                1L
        );

        Defect savedDefect = new Defect(
                "Login failure",
                "User cannot login with valid credentials",
                "HIGH",
                "OPEN",
                project
        );

        when(projectRepository.findById(1L))
                .thenReturn(Optional.of(project));

        when(defectRepository.save(any(Defect.class)))
                .thenReturn(savedDefect);

        DefectResponse response = defectService.createDefect(request);

        assertNotNull(response);
        assertEquals("Login failure", response.getTitle());
        assertEquals(
                "User cannot login with valid credentials",
                response.getDescription()
        );
        assertEquals("HIGH", response.getSeverity());
        assertEquals("OPEN", response.getStatus());

        verify(projectRepository, times(1))
                .findById(1L);

        verify(defectRepository, times(1))
                .save(any(Defect.class));
    }

    @Test
    void getDefectById_shouldReturnDefectSuccessfully() {

        Project project = new Project(
                "DevInsight",
                "Software Quality and Data Analytics Platform",
                "Java Spring Boot",
                "ACTIVE"
        );

        Defect defect = new Defect(
                "Database error",
                "Database connection failed",
                "CRITICAL",
                "OPEN",
                project
        );

        when(defectRepository.findById(1L))
                .thenReturn(Optional.of(defect));

        DefectResponse response = defectService.getDefectById(1L);

        assertNotNull(response);
        assertEquals("Database error", response.getTitle());
        assertEquals(
                "Database connection failed",
                response.getDescription()
        );
        assertEquals("CRITICAL", response.getSeverity());
        assertEquals("OPEN", response.getStatus());

        verify(defectRepository, times(1))
                .findById(1L);
    }

    @Test
    void getDefectById_shouldThrowExceptionWhenDefectNotFound() {

        when(defectRepository.findById(999L))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> defectService.getDefectById(999L)
        );

        assertEquals(
                "Defect not found with id: 999",
                exception.getMessage()
        );

        verify(defectRepository, times(1))
                .findById(999L);
    }
}