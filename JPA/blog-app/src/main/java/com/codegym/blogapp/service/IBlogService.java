package com.codegym.blogapp.service;

import com.codegym.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog>{
    Page<Blog> findAll(Pageable pageable);
}
