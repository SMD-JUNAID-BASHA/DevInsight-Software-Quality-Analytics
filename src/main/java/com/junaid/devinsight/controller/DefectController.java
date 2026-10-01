package com.junaid.devinsight.controller;

import com.junaid.devinsight.dto.DefectRequest;
import com.junaid.devinsight.dto.DefectResponse;
import com.junaid.devinsight.service.DefectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/defects")
public class DefectController {

    private final DefectService defectService;

    public DefectController(DefectService defectService) {
        this.defectService = defectService;
    }

    @GetMapping
    public ResponseEntity<List<DefectResponse>> getAllDefects() {
        return ResponseEntity.ok(
                defectService.getAllDefects()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefectResponse> getDefectById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                defectService.getDefectById(id)
        );
    }

    @PostMapping
    public ResponseEntity<DefectResponse> createDefect(
            @Valid @RequestBody DefectRequest request) {

        return ResponseEntity.ok(
                defectService.createDefect(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefectResponse> updateDefect(
            @PathVariable Long id,
            @Valid @RequestBody DefectRequest request) {

        return ResponseEntity.ok(
                defectService.updateDefect(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDefect(
            @PathVariable Long id) {

        defectService.deleteDefect(id);

        return ResponseEntity.noContent().build();
    }
}