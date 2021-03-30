package com.example.the425show;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Environment environment;



    public HelloController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public String hello() {

        return
                "env=" + environment.getProperty("server.forward-headers-strategy") + "\n" +
                        "cloud=" + CloudPlatform.getActive(environment) + "\n";
    }
}
