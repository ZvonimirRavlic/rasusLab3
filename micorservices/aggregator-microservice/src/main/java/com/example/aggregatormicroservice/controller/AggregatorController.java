package com.example.aggregatormicroservice.controller;


import com.example.aggregatormicroservice.pojos.Reading;
import com.example.aggregatormicroservice.service.AggregatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AggregatorController {

    private final AggregatorService aggregatorService;

    public AggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/reading")
    public List<Reading> getReading() {
        return aggregatorService.getReading();
    }
}
