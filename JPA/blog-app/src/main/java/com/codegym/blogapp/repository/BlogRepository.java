package com.codegym.blogapp.repository;

import com.codegym.blogapp.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c where c.id=:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Transactional
    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            blog.setUpdatedAt(LocalDateTime.now());
            entityManager.merge(blog);
        } else {
            blog.setCreatedAt(LocalDateTime.now());
            entityManager.persist(blog);
        }
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Blog Blog = findById(id);
        if (Blog != null) {
            entityManager.remove(Blog);
        }
    }
}