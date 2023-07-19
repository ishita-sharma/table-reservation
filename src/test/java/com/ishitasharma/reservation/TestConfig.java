package com.ishitasharma.reservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public CucumberTestInformation cucumberTestInformation() {
        return new CucumberTestInformation();
    }
}
