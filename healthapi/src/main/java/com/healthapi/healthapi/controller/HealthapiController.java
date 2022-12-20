package com.healthapi.healthapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthapiController {
    @RequestMapping("/")
    public String mensajePrueba(){
        return "Testing the API";
    }
}
