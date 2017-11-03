package com.codeup.blog.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }

    @ResponseBody
    @GetMapping("/hello/{firstName}/{lastName}")
    public String helloName(@PathVariable String firstName, @PathVariable String lastName) {
        return "Hello, " + firstName + " " + lastName + "!!";
    }


    @ResponseBody
    @GetMapping ("/square/{number}")
    public Double square(@PathVariable Double number) {
        return number*number;
    }
}
