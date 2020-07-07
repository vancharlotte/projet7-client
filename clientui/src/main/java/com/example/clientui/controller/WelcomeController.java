package com.example.clientui.controller;

import com.example.clientui.beans.AccountBean;
import com.example.clientui.client.LibraryAccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class WelcomeController {

    @Autowired
    private LibraryAccountClient userClient;


    @GetMapping("/")
    public String accueil(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        System.out.println("username : " + username);
        model.addAttribute("username", username);

        return "test";
    }






/*

   @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){
           new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "redirect:/";

    }
*/
}
