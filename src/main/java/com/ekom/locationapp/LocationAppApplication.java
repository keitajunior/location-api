package com.ekom.locationapp;

import com.ekom.locationapp.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class LocationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationAppApplication.class, args);
    }

}
