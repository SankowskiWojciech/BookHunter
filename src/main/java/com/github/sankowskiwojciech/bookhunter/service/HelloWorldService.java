package com.github.sankowskiwojciech.bookhunter.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/")
public class HelloWorldService {

    @RequestMapping(value = "helloworld", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World!";
    }

}
