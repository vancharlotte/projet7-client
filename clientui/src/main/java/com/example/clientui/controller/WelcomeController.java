package com.example.clientui.controller;

import com.example.clientui.client.LibraryAccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @Autowired
    private LibraryAccountClient userClient;

    @GetMapping("/")
    public String accueil(Model model) {
    /*    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        model.addAttribute("username", username);*/

        return "Homepage";
    }

}
