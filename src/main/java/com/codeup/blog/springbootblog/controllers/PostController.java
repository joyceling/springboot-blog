package com.codeup.blog.springbootblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String showAll(String index) {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showPost(@PathVariable int id) {
        return "view an individual post" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(String create) {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postPost(String post) {
        return "posts index page";
    }

}