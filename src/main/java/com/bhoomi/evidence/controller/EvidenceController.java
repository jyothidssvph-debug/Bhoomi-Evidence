package com.bhoomi.evidence.controller;

import com.bhoomi.evidence.model.Evidence;
import com.bhoomi.evidence.repository.EvidenceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evidence")
@CrossOrigin
public class EvidenceController {
    private final EvidenceRepository repository;

    public EvidenceController(EvidenceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Evidence> all() {
        return repository.findAll();
    }
}
