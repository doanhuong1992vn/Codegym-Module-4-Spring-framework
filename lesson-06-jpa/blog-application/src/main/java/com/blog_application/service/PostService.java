package com.blog_application.service;

import com.blog_application.entity.Post;

import java.util.List;

public interface PostService {
     List<Post> findAll();

     void save(Post post);
}