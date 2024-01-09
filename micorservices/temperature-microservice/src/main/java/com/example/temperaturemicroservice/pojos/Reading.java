package com.example.temperaturemicroservice.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reading {

    @Id
    @JsonIgnore
    private Long readingId;
    @JsonProperty(value = "name", index = 0)
    private String readingType = "Temperature";

    @JsonProperty( index = 1)
    private String unit = "C";
    @CsvBindByName(column = "Temperature")
    @JsonProperty(value = "value", index = 2)
    private Double readingValue;

    public Reading(Reading reading) {
        this.readingType = reading.getReadingType();
        this.unit = reading.getUnit();
        this.readingValue = reading.getReadingValue();
    }

    public Reading() {

    }

    public Long getReadingId() {
        return readingId;
    }

    public void setReadingId(Long readingId) {
        this.readingId = readingId;
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
