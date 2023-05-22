package com.picture_of_day.service.impl;

import com.picture_of_day.exception.DirtyWordException;
import com.picture_of_day.model.Comment;
import com.picture_of_day.repository.CommentRepository;
import com.picture_of_day.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public void save(Comment comment, BindingResult bindingResult) throws DirtyWordException {
        comment.setLikes(0);
        comment.setPostTime(LocalDateTime.now());
        new Comment().validate(comment, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new DirtyWordException(comment);
        }
        commentRepository.save(comment);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Page<Comment> findByPostTimeInDay(Pageable pageable) {
        return commentRepository.findByPostTimeInDay(pageable);
    }

    @Override
    public void setLike(long id) {
        Optional<Comment> optional = commentRepository.findById(id);
        if (optional.isPresent()) {
            Comment comment = optional.get();
            comment.setLikes(comment.getLikes() + 1);
            commentRepository.save(comment);
        }
    }
}
