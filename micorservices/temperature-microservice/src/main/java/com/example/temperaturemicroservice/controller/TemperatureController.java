package com.example.temperaturemicroservice.controller;

import com.example.temperaturemicroservice.pojos.Reading;
import com.example.temperaturemicroservice.service.TemperatureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/reading")
    public Reading getReading() {
        return temperatureService.getReading();
    }
}
