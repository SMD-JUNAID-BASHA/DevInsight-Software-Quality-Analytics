package com.junaid.devinsight.service;

import com.junaid.devinsight.dto.TestCaseRequest;
import com.junaid.devinsight.dto.TestCaseResponse;
import com.junaid.devinsight.entity.Project;
import com.junaid.devinsight.entity.TestCase;
import com.junaid.devinsight.repository.ProjectRepository;
import com.junaid.devinsight.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final ProjectRepository projectRepository;

    public TestCaseService(
            TestCaseRepository testCaseRepository,
            ProjectRepository projectRepository) {

        this.testCaseRepository = testCaseRepository;
        this.projectRepository = projectRepository;
    }

    public List<TestCaseResponse> getAllTestCases() {
        return testCaseRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    public TestCaseResponse getTestCaseById(Long id) {
        return testCaseRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() ->
                        new RuntimeException("Test case not found with id: " + id));
    }

    public TestCaseResponse createTestCase(TestCaseRequest request) {

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project not found with id: " + request.getProjectId()
                        ));

        TestCase testCase = new TestCase();

        testCase.setTestCaseName(request.getTestCaseName());
        testCase.setDescription(request.getDescription());
        testCase.setStatus(request.getStatus());
        testCase.setPriority(request.getPriority());
        testCase.setProject(project);

        TestCase savedTestCase = testCaseRepository.save(testCase);

        return convertToResponse(savedTestCase);
    }

    public TestCaseResponse updateTestCase(
            Long id,
            TestCaseRequest request) {

        return testCaseRepository.findById(id)
                .map(testCase -> {

                    Project project = projectRepository.findById(
                                    request.getProjectId())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Project not found with id: "
                                                    + request.getProjectId()
                                    ));

                    testCase.setTestCaseName(request.getTestCaseName());
                    testCase.setDescription(request.getDescription());
                    testCase.setStatus(request.getStatus());
                    testCase.setPriority(request.getPriority());
                    testCase.setProject(project);

                    TestCase updatedTestCase =
                            testCaseRepository.save(testCase);

                    return convertToResponse(updatedTestCase);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Test case not found with id: " + id
                        ));
    }

    public void deleteTestCase(Long id) {

        if (!testCaseRepository.existsById(id)) {
            throw new RuntimeException(
                    "Test case not found with id: " + id
            );
        }

        testCaseRepository.deleteById(id);
    }

    private TestCaseResponse convertToResponse(TestCase testCase) {

        return new TestCaseResponse(
                testCase.getId(),
                testCase.getTestCaseName(),
                testCase.getDescription(),
                testCase.getStatus(),
                testCase.getPriority(),
                testCase.getProject().getId()
        );
    }
}