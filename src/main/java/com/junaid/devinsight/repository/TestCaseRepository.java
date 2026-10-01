package com.junaid.devinsight.repository;

import com.junaid.devinsight.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}