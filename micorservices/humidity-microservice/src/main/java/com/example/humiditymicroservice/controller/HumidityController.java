package com.example.humiditymicroservice.controller;

import com.example.humiditymicroservice.pojos.Reading;
import com.example.humiditymicroservice.service.HumidityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumidityController {

    private final HumidityService humidityService;

    public HumidityController(HumidityService humidityService) {
        this.humidityService = humidityService;
    }

    @GetMapping("/reading")
    public Reading getReading() {
        return humidityService.getReading();
    }
}
