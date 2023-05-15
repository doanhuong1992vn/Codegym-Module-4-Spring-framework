package com.blog_application.repository.impl;

import com.blog_application.entity.Post;
import com.blog_application.repository.PostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Transactional
@Repository
public class PostRepositoryImpl implements PostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> findAll() {
        return entityManager.createQuery("from Post", Post.class).getResultList();
    }

    @Override
    public void save(Post post) {
        entityManager.persist(post);
    }
}
