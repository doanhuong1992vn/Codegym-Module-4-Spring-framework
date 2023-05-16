package com.blog_application.repository;

import com.blog_application.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    List<Post> findAll();

    void save(Post post);

    Post findById(Long id);

    void delete(Long id);

}
