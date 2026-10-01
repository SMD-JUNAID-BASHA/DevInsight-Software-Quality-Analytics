package com.junaid.devinsight.controller;

import com.junaid.devinsight.dto.TestCaseRequest;
import com.junaid.devinsight.dto.TestCaseResponse;
import com.junaid.devinsight.service.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-cases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponse>> getAllTestCases() {
        return ResponseEntity.ok(
                testCaseService.getAllTestCases()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponse> getTestCaseById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                testCaseService.getTestCaseById(id)
        );
    }

    @PostMapping
    public ResponseEntity<TestCaseResponse> createTestCase(
            @Valid @RequestBody TestCaseRequest request) {

        return ResponseEntity.ok(
                testCaseService.createTestCase(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponse> updateTestCase(
            @PathVariable Long id,
            @Valid @RequestBody TestCaseRequest request) {

        return ResponseEntity.ok(
                testCaseService.updateTestCase(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(
            @PathVariable Long id) {

        testCaseService.deleteTestCase(id);

        return ResponseEntity.noContent().build();
    }
}