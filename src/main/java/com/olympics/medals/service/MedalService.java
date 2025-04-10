package com.olympics.medals.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olympics.medals.model.Medal;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedalService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Medal> olympicMedals;
    private List<Medal> paralympicMedals;

    public MedalService() {
        try {
            olympicMedals = loadMedals("response.json");
            paralympicMedals = loadMedals("paralympic-response.json");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load medal data", e);
        }
    }

    private List<Medal> loadMedals(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);
        if (resource.exists()) {
            return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Medal>>() {});
        }
        return List.of();
    }

    public List<Medal> getOlympicMedals(String countryCode) {
        return filterMedals(olympicMedals, countryCode);
    }

    public List<Medal> getParalympicMedals(String countryCode) {
        return filterMedals(paralympicMedals, countryCode);
    }

    private List<Medal> filterMedals(List<Medal> medals, String countryCode) {
        if (countryCode == null || countryCode.isEmpty()) {
            return medals;
        }
        return medals.stream()
                .filter(medal -> medal.getCountryCode().equalsIgnoreCase(countryCode))
                .collect(Collectors.toList());
    }
} 