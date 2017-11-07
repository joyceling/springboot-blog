package com.codeup.blog.springbootblog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    public Post (Long id, String title, String body){
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post (String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post (){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId () {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
