package com.example.aggregatormicroservice.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reading {
    @JsonProperty(value = "name", index = 0)
    private String readingType = "Humidity";
    @JsonProperty(index = 1)
    private String unit = "%";
    @JsonProperty(value = "value", index = 2)
    private Double readingValue;

    public Reading(Reading reading) {
        this.readingType = reading.getReadingType();
        this.unit = reading.getUnit();
        this.readingValue = reading.getReadingValue();
    }

    public Reading() {

    }


    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getReadingValue() {
        return readingValue;
    }

    public void setReadingValue(Double readingValue) {
        this.readingValue = readingValue;
    }

}
