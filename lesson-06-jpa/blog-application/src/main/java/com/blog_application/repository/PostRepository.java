package com.blog_application.repository;

import com.blog_application.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();

    void save(Post post);

    Post findById(Long id);
}
