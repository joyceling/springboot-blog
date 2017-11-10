package com.codeup.blog.springbootblog.repositories;

import com.codeup.blog.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Users extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
