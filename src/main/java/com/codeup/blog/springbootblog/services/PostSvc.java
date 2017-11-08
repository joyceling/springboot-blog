package com.codeup.blog.springbootblog.services;

import com.codeup.blog.springbootblog.models.Post;
import com.codeup.blog.springbootblog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PostSvc")
public class PostSvc {
    private final PostsRepository postDao;

    @Autowired
    public PostSvc(PostsRepository postDao) {
        this.postDao = postDao;
    }

    // Gets all the posts
    public List<Post> findAll() {
        return (List<Post>) postDao.findAll();
    }

    // Gets one post
    public Post findOne(Long id) {

        return (Post) postDao.findOne(id);
    }

    // Saves a post with just title and desc
    public void save (Post post) {
        postDao.save(post);
    }

    public void delete (Long id) {
        postDao.delete(id);
    }

    // Creates a bunch of dummy data

//    private void createPosts() {
//
//        save(new Post("post1", "lorem ipsum"));
//        save(new Post("post2", "lorem ipsum"));
//        save(new Post("post3", "lorem ipsum"));
//
//    }

}
