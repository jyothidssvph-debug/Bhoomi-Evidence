package com.bhoomi.evidence.repository;

import com.bhoomi.evidence.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvidenceRepository extends JpaRepository<Evidence, Long> {}
