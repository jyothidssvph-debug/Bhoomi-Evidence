package com.bhoomi.evidence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;
    private int urbanPressure;
    private int agriculturalSensitivity;
    private int climateVulnerability;
    private int infrastructureOpportunity;

    public District() {}

    public District(String name, String state, int urbanPressure, int agriculturalSensitivity,
                    int climateVulnerability, int infrastructureOpportunity) {
        this.name = name;
        this.state = state;
        this.urbanPressure = urbanPressure;
        this.agriculturalSensitivity = agriculturalSensitivity;
        this.climateVulnerability = climateVulnerability;
        this.infrastructureOpportunity = infrastructureOpportunity;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getState() { return state; }
    public int getUrbanPressure() { return urbanPressure; }
    public int getAgriculturalSensitivity() { return agriculturalSensitivity; }
    public int getClimateVulnerability() { return climateVulnerability; }
    public int getInfrastructureOpportunity() { return infrastructureOpportunity; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setState(String state) { this.state = state; }
    public void setUrbanPressure(int v) { this.urbanPressure = v; }
    public void setAgriculturalSensitivity(int v) { this.agriculturalSensitivity = v; }
    public void setClimateVulnerability(int v) { this.climateVulnerability = v; }
    public void setInfrastructureOpportunity(int v) { this.infrastructureOpportunity = v; }
}
