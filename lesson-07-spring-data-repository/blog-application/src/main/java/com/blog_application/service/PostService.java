package com.blog_application.service;

import com.blog_application.entity.Post;

import java.util.List;

public interface PostService {
     List<Post> findAll();

     void save(Post post);

    Post findById(Long id);

    void delete(Long id);

    void update(Post post);
}
