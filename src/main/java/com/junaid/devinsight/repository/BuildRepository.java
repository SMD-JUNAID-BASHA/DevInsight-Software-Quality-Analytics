package com.junaid.devinsight.repository;

import com.junaid.devinsight.entity.Build;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildRepository extends JpaRepository<Build, Long> {
}