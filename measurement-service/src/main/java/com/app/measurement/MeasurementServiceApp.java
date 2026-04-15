package com.app.measurement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MeasurementServiceApp {
    public static void main(String[] args) {

        SpringApplication.run(MeasurementServiceApp.class, args);
    }
}
