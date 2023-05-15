package com.blog_application.service.impl;

import com.blog_application.entity.Post;
import com.blog_application.repository.PostRepository;
import com.blog_application.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        post.setPostTime(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id);
    }
}
