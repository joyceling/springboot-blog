package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String showAll(String index, Model model) {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post("Welcome!", "This is my first post");
        Post post2 = new Post("Second Post", "Stick around for more!");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable int id, Model model) {
        Post post = new Post("title", "description");
        model.addAttribute("post", post);

        return "posts/show";
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
