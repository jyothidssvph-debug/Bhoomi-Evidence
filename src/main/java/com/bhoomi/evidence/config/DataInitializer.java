package com.bhoomi.evidence.config;

import com.bhoomi.evidence.model.District;
import com.bhoomi.evidence.model.Evidence;
import com.bhoomi.evidence.repository.DistrictRepository;
import com.bhoomi.evidence.repository.EvidenceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seed(EvidenceRepository evidenceRepository, DistrictRepository districtRepository) {
        return args -> {
            if (evidenceRepository.count() == 0) {
                evidenceRepository.save(new Evidence(
                    "Land-use transition and climate exposure — demo synthesis",
                    "Illustrative policy research record",
                    "2025-06-15",
                    "Research synthesis",
                    "Rayalaseema",
                    "Moderate",
                    "Demo finding: districts experiencing stronger development pressure may require spatial safeguards that account for agricultural sensitivity and climate exposure."
                ));
                evidenceRepository.save(new Evidence(
                    "Agricultural land protection and spatial planning — demo study",
                    "Illustrative planning study",
                    "2024-11-20",
                    "Policy paper",
                    "Andhra Pradesh",
                    "Moderate",
                    "Demo finding: scenario-based planning can make trade-offs between development and agricultural protection easier to communicate."
                ));
                evidenceRepository.save(new Evidence(
                    "Geospatial indicators for land governance — demo dataset",
                    "Illustrative geospatial dataset",
                    "2025-01-10",
                    "Dataset",
                    "Kurnool region",
                    "High",
                    "Demo dataset containing normalized indicators for urban pressure, agricultural sensitivity, climate vulnerability and infrastructure opportunity."
                ));
            }

            if (districtRepository.count() == 0) {
                districtRepository.save(new District("Kurnool", "Andhra Pradesh", 68, 74, 63, 79));
                districtRepository.save(new District("Nandyal", "Andhra Pradesh", 54, 81, 69, 67));
                districtRepository.save(new District("Anantapur", "Andhra Pradesh", 61, 72, 78, 70));
                districtRepository.save(new District("Kadapa", "Andhra Pradesh", 57, 76, 71, 73));
            }
        };
    }
}
