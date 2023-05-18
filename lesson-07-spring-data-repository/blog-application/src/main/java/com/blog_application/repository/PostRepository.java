package com.blog_application.repository;

import com.blog_application.entity.Category;
import com.blog_application.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findAllByCategory(Category category);
}
