package com.example.springinpractice;

import com.example.springinpractice.configurationproperties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private final AppProperties appProperties;

    @Autowired
    public AppService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public AppProperties getAppProperties() {
        return appProperties;
    }
}
