package com.ishitasharma.reservation;

import io.cucumber.spring.ScenarioScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ScenarioScope
public class CucumberTestInformation {
    private Map<String, Object> contextMap = new HashMap<>();

    public Map<String, Object> getContextMap() {
        return contextMap;
    }

    public void setContextMap(Map<String, Object> contextMap) {
        this.contextMap = contextMap;
    }
}
