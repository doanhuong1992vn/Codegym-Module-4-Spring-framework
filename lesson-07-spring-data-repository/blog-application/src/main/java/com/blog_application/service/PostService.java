package com.blog_application.service;

import com.blog_application.entity.Category;
import com.blog_application.entity.Post;

public interface PostService extends GeneralService<Post> {
    Iterable<Post> findAllByCategory(Category value);
}
