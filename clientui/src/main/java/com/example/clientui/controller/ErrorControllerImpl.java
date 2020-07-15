package com.example.clientui.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorControllerImpl implements ErrorController {

    @GetMapping("/error")
    public ModelAndView handleError(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            modelAndView.setViewName("error/notFound");
        }
        else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            modelAndView.setViewName("error/accessDenied");
        }
        else if(response.getStatus() == HttpStatus.UNAUTHORIZED.value()) {
            modelAndView.setViewName("error/accessDenied");
        }
        else {
            modelAndView.setViewName("error/error");
        }

        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
