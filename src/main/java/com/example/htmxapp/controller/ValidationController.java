package com.example.htmxapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/validation")
public class ValidationController {

    @PostMapping("/email")
    @ResponseBody
    public String validateEmail(String email) {
        Map<String, String> isValid = new HashMap<>();
        isValid.put("message", "That email is valid");
        isValid.put("class", "text-green-700");

        Map<String, String> isInvalid = new HashMap<>();
        isInvalid.put("message", "Please enter a valid email address");
        isInvalid.put("class", "text-red-700");

        if (email != null && email.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")) {
            return "<div class=\"mb-4\" hx-target=\"this\" hx-swap=\"outerHTML\">" +
                    "<label class=\"block text-gray-700 text-sm font-bold mb-2\" for=\"email\">Email Address</label>" +
                    "<input name=\"email\" hx-post=\"/validation/email\" class=\"border rounded-lg py-2 px-3 w-full focus:outline-none focus:border-blue-500\" type=\"email\" id=\"email\" value=\""
                    + email + "\" required />" +
                    "<div class=\"" + isValid.get("class") + "\">" + isValid.get("message") + "</div>" +
                    "</div>";
        } else {
            return "<div class=\"mb-4\" hx-target=\"this\" hx-swap=\"outerHTML\">" +
                    "<label class=\"block text-gray-700 text-sm font-bold mb-2\" for=\"email\">Email Address</label>" +
                    "<input name=\"email\" hx-post=\"/validation/email\" class=\"border rounded-lg py-2 px-3 w-full focus:outline-none focus:border-blue-500\" type=\"email\" id=\"email\" value=\""
                    + email + "\" required />" +
                    "<div class=\"" + isInvalid.get("class") + "\">" + isInvalid.get("message") + "</div>" +
                    "</div>";
        }
    }

}
