package com.example.aggregatormicroservice.service;

import com.example.aggregatormicroservice.pojos.Reading;
import com.example.aggregatormicroservice.pojos.YmlProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregatorService {

    @Autowired
    private RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;
    private final YmlProps ymlProps;
    private final ApplicationEventPublisher applicationEventPublisher;


    public AggregatorService(DiscoveryClient discoveryClient, YmlProps ymlProps, ApplicationEventPublisher applicationEventPublisher) {

        this.discoveryClient = discoveryClient;
        this.ymlProps = ymlProps;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public List<Reading> getReading() {
        final List<Reading> aggregateReading = new ArrayList<>();
        applicationEventPublisher.publishEvent(new RefreshEvent(this, "RefreshEvent", "Refreshing scope"));
        ServiceInstance tempService1 = discoveryClient.getInstances("humidity-microservice").get(0);
        String tempUrl1 = tempService1.getUri().toString() + "/reading";
        System.out.println(tempUrl1);
        aggregateReading.add(this.restTemplate.getForObject(tempUrl1, Reading.class));
        ServiceInstance tempService2 = discoveryClient.getInstances("temperature-microservice").get(0);
        String tempUrl2 = tempService2.getUri().toString() + "/reading";
        System.out.println(tempUrl2);
        aggregateReading.add(this.restTemplate.getForObject(tempUrl2, Reading.class));
        if (ymlProps.getUnit().equals("K")) {
            aggregateReading.get(1).setUnit("K");
            aggregateReading.get(1).setReadingValue(aggregateReading.get(1).getReadingValue() + 274.15);
        }
        return aggregateReading;
    }
}
