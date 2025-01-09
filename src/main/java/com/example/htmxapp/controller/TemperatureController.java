package com.example.htmxapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TemperatureController {

    @PostMapping("/convert")
    @ResponseBody
    public String convertTemperature(@RequestParam Float fahrenheit) {
        if (fahrenheit == null) {
            throw new IllegalArgumentException("Fahrenheit value cannot be null.");
        }

        try {
            // Simulate delay to see the loader
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted during temperature conversion", e);
        }

        float celsius = (fahrenheit - 32) * (5.0f / 9.0f);
        return String.format("<p>%.2f degrees Fahrenheit is equal to %.2f degrees Celsius</p>", fahrenheit, celsius);
    }
};