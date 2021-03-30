package com.example.the425show;

import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Iterator;

@RestController
public class HelloController {

    private final Environment environment;

    public HelloController(Environment environment) {
        this.environment = environment;
    }



    @GetMapping("/")
    public String hello(HttpServletRequest request) {
        return
                "env=" +
                        environment.getProperty("server.forward-headers-strategy") + "\n" +
                        "cloud=" + CloudPlatform.getActive(environment) + "\n" +
                "headers=" + printHeaders(request);
    }

    private String printHeaders(HttpServletRequest request) {
        String headers = "";
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers += "Header Name - " + headerName + ", Value - " + request.getHeader(headerName) + " | ";
        }
        return headers;
    }
}
