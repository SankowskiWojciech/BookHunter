package com.github.sankowskiwojciech.bookhunter.controller.home;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HomeControllerImpl {

    @GetMapping
    public ModelAndView findAuthorById() {

        ModelAndView modelAndView = new ModelAndView("home/home");

        return modelAndView;
    }
}