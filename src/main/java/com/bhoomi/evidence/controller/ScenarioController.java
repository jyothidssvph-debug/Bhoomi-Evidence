package com.bhoomi.evidence.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/scenarios")
@CrossOrigin
public class ScenarioController {

    @PostMapping("/compare")
    public Map<String, Object> compare(@RequestBody ScenarioRequest request) {
        int urban = clamp(request.urbanGrowthControl());
        int agriculture = clamp(request.agriculturalProtection());

        double development = 55 + (urban * 0.22) + ((100 - agriculture) * 0.12);
        double resilience = 45 + (agriculture * 0.38) + (urban * 0.12);
        double pressure = 75 - (urban * 0.45) + ((100 - agriculture) * 0.08);

        return Map.of(
            "urbanGrowthControl", urban,
            "agriculturalProtection", agriculture,
            "developmentScore", round(development),
            "resilienceScore", round(resilience),
            "landPressure", round(pressure),
            "interpretation", interpretation(urban, agriculture)
        );
    }

    private int clamp(int x) {
        return Math.max(0, Math.min(100, x));
    }

    private double round(double x) {
        return Math.round(x * 10.0) / 10.0;
    }

    private String interpretation(int urban, int agriculture) {
        if (urban >= 70 && agriculture >= 70)
            return "Higher protection with controlled growth; prioritizes resilience and agricultural land retention.";
        if (urban >= 70)
            return "Growth is more tightly controlled; infrastructure expansion should be targeted.";
        if (agriculture >= 70)
            return "Agricultural protection is prioritized; urban expansion needs stronger spatial safeguards.";
        return "Balanced growth profile; monitor land pressure and climate exposure as development expands.";
    }

    public record ScenarioRequest(int urbanGrowthControl, int agriculturalProtection) {}
}
