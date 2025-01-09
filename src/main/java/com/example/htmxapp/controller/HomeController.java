package com.example.htmxapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Retrieving a json, displaying data demo.
    @GetMapping("/request")
    public String request() {
        return "request";
    }

    // Sending a value through a POST req, returning html with conversion demo.
    @GetMapping("/temperature")
    public String temperature() {
        return "temperature";
    }

    // Polling some data every 5 seconds demo.
    @GetMapping("/polling")
    public String polling() {
        return "polling";
    }

    // Search some hardcoded data, and search some data from an api demo.
    @GetMapping("/searching")
    public String searching() {
        return "searching";
    }

    // Validate fields in a form, in this case, validating an email with regex demo.
    @GetMapping("/validating")
    public String validating() {
        return "validating";
    }
}
