package com.olympics.medals.model;

import lombok.Data;

@Data
public class Medal {
    private String country;
    private String countryCode;
    private int gold;
    private int silver;
    private int bronze;
    private int total;
} 