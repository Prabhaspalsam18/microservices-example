package com.training.stockservice.profile_examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdEnvironment implements Environment {
    @Value("${welcome.message}")
    String welcomeMessage;

    @Override
    public String getEnvironment() {
        //return welcomeMessage;
        return welcomeMessage;
    }
}
