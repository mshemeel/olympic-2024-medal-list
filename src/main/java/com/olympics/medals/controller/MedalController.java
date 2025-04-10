package com.olympics.medals.controller;

import com.olympics.medals.model.Medal;
import com.olympics.medals.service.MedalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedalController {
    private final MedalService medalService;

    public MedalController(MedalService medalService) {
        this.medalService = medalService;
    }

    @GetMapping("/medals")
    public List<Medal> getOlympicMedals(@RequestParam(required = false) String country) {
        return medalService.getOlympicMedals(country);
    }

    @GetMapping("/paralympics/medals")
    public List<Medal> getParalympicMedals(@RequestParam(required = false) String country) {
        return medalService.getParalympicMedals(country);
    }
} 