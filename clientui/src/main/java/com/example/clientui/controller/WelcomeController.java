package com.example.clientui.controller;

import com.example.clientui.beans.BookBean;
import com.example.clientui.beans.UserBean;
import com.example.clientui.client.LibraryLoanClient;
import com.example.clientui.client.LibraryUserClient;
import org.apache.catalina.Session;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class WelcomeController {

    @Autowired
    private LibraryUserClient userClient;


    @GetMapping("/")
    public String accueil() {
        return "Accueil";
    }

    @GetMapping("/index")
    public String index() {
        return "test";
    }

/*
    @PostMapping("/login")
    public String login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, Model model, HttpServletRequest request) {
        String result = userClient.login(email, password);
        if (result.equals("success")){
            HttpSession session = request.getSession();
            session.setAttribute("user", userClient.findUserByEmail(email));
            model.addAttribute("user", request.getSession().getAttribute("user"));
            return "test";
    }
        else{
            return "login";
        }
    }*/

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        return "login";
    }

}
