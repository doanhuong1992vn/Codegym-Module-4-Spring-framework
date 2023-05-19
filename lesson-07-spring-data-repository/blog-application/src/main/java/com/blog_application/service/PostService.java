package com.blog_application.service;

import com.blog_application.entity.Category;
import com.blog_application.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService extends GeneralService<Post> {
    Iterable<Post> findAllByCategory(Category value);
    Page<Post> findAll(Pageable pageable);
    Page<Post> findAllByCategory(Category value, Pageable pageable);

}
