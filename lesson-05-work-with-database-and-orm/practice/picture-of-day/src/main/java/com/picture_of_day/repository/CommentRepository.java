package com.picture_of_day.repository;

import com.picture_of_day.model.Comment;

import java.util.List;

public interface CommentRepository {
    void save(Comment comment);

    List<Comment> getAll();

    Comment getById(long id);
}
