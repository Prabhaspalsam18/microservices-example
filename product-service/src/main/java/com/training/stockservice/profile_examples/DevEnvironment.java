package com.training.stockservice.profile_examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default"})
public class DevEnvironment implements Environment {

    @Value("${welcome.message}")
    String welcomeMessage;

    @Override
    public String getEnvironment() {
        return welcomeMessage;
        //return "dev or default environment";
    }
}
