package com.example.humiditymicroservice.service;

import com.example.humiditymicroservice.pojos.Reading;
import com.example.humiditymicroservice.pojos.ReadingRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class HumidityService {

    private final List<Reading> readings = new CsvToBeanBuilder(new FileReader("readings.csv"))
            .withType(Reading.class).build().parse();
    private Long id = 1L;
    private final ReadingRepository readingRepository;

    public HumidityService(ReadingRepository readingRepository) throws FileNotFoundException {
        this.readingRepository = readingRepository;
    }

    public Reading getReading() {
        final Reading reading = new Reading(readings.get((int) (System.currentTimeMillis() / 60000) % 100));
        reading.setReadingId(id++);
        readingRepository.save(reading);
        return reading;
    }
}
