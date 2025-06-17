package com.codegym.blogapp.service;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void save(Blog customer) {
        iBlogRepository.save(customer);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        iBlogRepository.deleteById(id);
    }

    public Page<Blog> searchBlogs(String keyword, Pageable pageable) {
        return iBlogRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    public Page<Blog> findPostsByCategory(Long categoryId, Pageable pageable) {
        return iBlogRepository.findByCategoryId(categoryId, pageable);
    }
}
