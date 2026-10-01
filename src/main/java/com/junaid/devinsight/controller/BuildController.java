package com.junaid.devinsight.controller;

import com.junaid.devinsight.dto.BuildRequest;
import com.junaid.devinsight.dto.BuildResponse;
import com.junaid.devinsight.service.BuildService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/builds")
public class BuildController {

    private final BuildService buildService;

    public BuildController(BuildService buildService) {
        this.buildService = buildService;
    }

    @GetMapping
    public ResponseEntity<List<BuildResponse>> getAllBuilds() {
        return ResponseEntity.ok(
                buildService.getAllBuilds()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildResponse> getBuildById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                buildService.getBuildById(id)
        );
    }

    @PostMapping
    public ResponseEntity<BuildResponse> createBuild(
            @Valid @RequestBody BuildRequest request) {

        return ResponseEntity.ok(
                buildService.createBuild(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildResponse> updateBuild(
            @PathVariable Long id,
            @Valid @RequestBody BuildRequest request) {

        return ResponseEntity.ok(
                buildService.updateBuild(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuild(
            @PathVariable Long id) {

        buildService.deleteBuild(id);

        return ResponseEntity.noContent().build();
    }
}