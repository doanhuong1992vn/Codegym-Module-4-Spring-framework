package com.blog_application.service;

import com.blog_application.entity.Post;

import java.util.Optional;

public interface PostService {
    Iterable<Post> findAll();

    void save(Post post);

    Optional<Post> findById(Long id);

    void delete(Long id);

    void update(Post post);
}
