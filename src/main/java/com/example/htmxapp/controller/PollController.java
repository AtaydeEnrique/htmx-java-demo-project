package com.example.htmxapp.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PollController {

    private Integer counter = 0;
    private Double currentTemperature = 20.0;

    @GetMapping("/poll")
    @ResponseBody
    public HashMap<String, Integer> getPoll() {
        counter += 1;
        HashMap<String, Integer> data = new HashMap<>();
        data.put("value", counter);

        return data;
    }

    @GetMapping("/temperature-poll")
    @ResponseBody
    public String getTemperaturePoll() {
        currentTemperature += (Math.random() * 2) - 1;

        return String.format("%.2f °C", currentTemperature);
    }

}
