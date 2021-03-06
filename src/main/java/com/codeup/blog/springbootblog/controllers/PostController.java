package com.codeup.blog.springbootblog.controllers;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.models.User;
import com.codeup.blog.springbootblog.repositories.UsersRepository;
import com.codeup.blog.springbootblog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PostController {

    private final PostSvc postsvc;
    private final UsersRepository usersrepo;

    // Constructor injection
    // The application requires autowired only when you have multiple constructors
    @Autowired
    public PostController (PostSvc postsvc, UsersRepository usersrepo) {

        this.postsvc = postsvc;
        this.usersrepo = usersrepo;

    }

    @GetMapping("/posts")
    public String showAll(String index, Model model) {

        List<Post> posts = postsvc.findAll();

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable Long id, Model model) {

        Post post = postsvc.findOne(id);

        model.addAttribute("post", post);
        model.addAttribute("postId", id);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postPost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
         @ModelAttribute Post post
    ) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);

       postsvc.save(post);

       return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable Long id) {

        model.addAttribute("post", postsvc.findOne(id));

        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @ModelAttribute Post post
    ) {
        postsvc.save(post);

        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postsvc.delete(id);
        return "redirect:/posts";
    }

}