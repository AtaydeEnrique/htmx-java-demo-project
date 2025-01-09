package com.example.htmxapp.controller;

import com.example.htmxapp.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    private List<Contact> contacts = new ArrayList<>();

    public SearchController() {
        contacts.add(new Contact("John Doe", "john.doe@example.com"));
        contacts.add(new Contact("Jane Smith", "jane.smith@example.com"));
        contacts.add(new Contact("Alice Jones", "alice.jones@example.com"));
        contacts.add(new Contact("Bob Brown", "bob.brown@example.com"));
        contacts.add(new Contact("Charlie Black", "charlie.black@example.com"));
        contacts.add(new Contact("David White", "david.white@example.com"));
    }

    @PostMapping
    @ResponseBody
    public String search(String search) {
        if (search == null || search.isEmpty()) {
            return "<tr></tr>";
        }

        String term = search.toLowerCase();

        List<Contact> results = contacts.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(term)
                        || contact.getEmail().toLowerCase().contains(term))
                .collect(Collectors.toList());

        return results.stream()
                .map(contact -> "<tr>" +
                        "<td><div class=\"my-4 p-2\">" + contact.getName() + "</div></td>" +
                        "<td><div class=\"my-4 p-2\">" + contact.getEmail() + "</div></td>" +
                        "</tr>")
                .collect(Collectors.joining());
    }

    @PostMapping("/api")
    @ResponseBody
    public String searchFromJson(String search) {
        if (search == null || search.isEmpty()) {
            return "<tr></tr>";
        }

        String term = search.toLowerCase();

        String url = UriComponentsBuilder.fromUriString("https://jsonplaceholder.typicode.com/users")
                .toUriString();

        Contact[] contactArray = restTemplate.getForObject(url, Contact[].class);
        List<Contact> contacts = Arrays.asList(contactArray);

        List<Contact> results = contacts.stream()
                .filter(contact -> contact.getName().toLowerCase().contains(term)
                        || contact.getEmail().toLowerCase().contains(term))
                .collect(Collectors.toList());

        return results.stream()
                .map(contact -> "<tr>" +
                        "<td><div class=\"my-4 p-2\">" + contact.getName() + "</div></td>" +
                        "<td><div class=\"my-4 p-2\">" + contact.getEmail() + "</div></td>" +
                        "</tr>")
                .collect(Collectors.joining());
    }
}