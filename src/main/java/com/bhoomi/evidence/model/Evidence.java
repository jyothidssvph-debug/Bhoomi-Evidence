package com.bhoomi.evidence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String source;
    private String datePublished;
    private String type;
    private String geography;
    private String strength;

    @Column(length = 3000)
    private String summary;

    public Evidence() {}

    public Evidence(String title, String source, String datePublished, String type,
                    String geography, String strength, String summary) {
        this.title = title;
        this.source = source;
        this.datePublished = datePublished;
        this.type = type;
        this.geography = geography;
        this.strength = strength;
        this.summary = summary;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getSource() { return source; }
    public String getDatePublished() { return datePublished; }
    public String getType() { return type; }
    public String getGeography() { return geography; }
    public String getStrength() { return strength; }
    public String getSummary() { return summary; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setSource(String source) { this.source = source; }
    public void setDatePublished(String datePublished) { this.datePublished = datePublished; }
    public void setType(String type) { this.type = type; }
    public void setGeography(String geography) { this.geography = geography; }
    public void setStrength(String strength) { this.strength = strength; }
    public void setSummary(String summary) { this.summary = summary; }
}
