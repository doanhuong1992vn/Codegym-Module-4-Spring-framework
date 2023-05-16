package com.blog_application.repository.impl;

import com.blog_application.entity.Post;
import com.blog_application.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (post.getId() != null) {
            entityManager.merge(post);
        } else {
            entityManager.persist(post);
        }
    }

    @Override
    public Post findById(Long id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("delete from Post where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

}
