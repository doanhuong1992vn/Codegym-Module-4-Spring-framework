package com.picture_of_day.service.impl;

import com.picture_of_day.model.Comment;
import com.picture_of_day.repository.CommentRepository;
import com.picture_of_day.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(Comment comment) {
        comment.setLikes(0);
        comment.setPostTime(new Date());
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.getAll();
    }

    @Override
    public void setLike(long id) {
        Comment comment = commentRepository.getById(id);
        long likes = comment.getLikes();
        comment.setLikes(likes + 1);
        commentRepository.save(comment);
    }
}
