package com.example.htmxapp.controller;

import com.example.htmxapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

// import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users")
    public String getUsers(Model model, @RequestParam Integer limit) {
        // List<User> users = Arrays.asList(
        // new User(1, "John Doe"),
        // new User(2, "Jane Smith"),
        // new User(3, "Alice Johnson")
        // );
        String url = UriComponentsBuilder.fromUriString("https://jsonplaceholder.typicode.com/users")
                .queryParam("_limit", (limit == null) ? 10 : limit)
                .toUriString();

        User[] users = restTemplate.getForObject(url, User[].class);

        model.addAttribute("users", users);

        return "fragments/users :: users";
    }
}
