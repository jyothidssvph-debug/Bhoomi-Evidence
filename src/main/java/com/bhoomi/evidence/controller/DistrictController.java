package com.bhoomi.evidence.controller;

import com.bhoomi.evidence.model.District;
import com.bhoomi.evidence.repository.DistrictRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin
public class DistrictController {
    private final DistrictRepository repository;

    public DistrictController(DistrictRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<District> all() {
        return repository.findAll();
    }
}
