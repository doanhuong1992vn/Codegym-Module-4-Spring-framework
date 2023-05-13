package com.picture_of_day.repository.impl;

import com.picture_of_day.model.Comment;
import com.picture_of_day.repository.CommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
@Repository
public class CommentRepositoryImpl implements CommentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }
    }

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = entityManager
                .createQuery("FROM Comment WHERE DATE(postTime) = CURDATE()", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment getById(long id) {
        TypedQuery<Comment> query = entityManager
                .createQuery("from Comment where id = :id", Comment.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }
}
