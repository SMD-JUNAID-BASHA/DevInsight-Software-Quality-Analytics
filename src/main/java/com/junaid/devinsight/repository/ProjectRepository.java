package com.junaid.devinsight.repository;

import com.junaid.devinsight.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}