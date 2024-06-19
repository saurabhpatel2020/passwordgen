package com.example.passwordgenerator.controller;

import com.example.passwordgenerator.service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordGeneratorController {

    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @GetMapping("/")
    public String showPasswordGeneratorForm() {
        return "index";
    }

    @PostMapping("/generate")
    public String generatePassword(@RequestParam("length") int length, Model model) {
        String password = passwordGeneratorService.generatePassword(length);
        model.addAttribute("password", password);
        return "index";
    }
}