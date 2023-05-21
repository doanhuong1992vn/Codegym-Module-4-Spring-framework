package com.picture_of_day.service;

import com.picture_of_day.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    void save(Comment comment);

    Page<Comment> findAll(Pageable pageable);

    Page<Comment> findByPostTimeInDay(Pageable pageable);

    void setLike(long id);
}
