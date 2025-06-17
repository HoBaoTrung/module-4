package com.codegym.blogapp.repository;


import com.codegym.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Long > {
    Page<Blog> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    Page<Blog> findByCategoryId(Long categoryId, Pageable pageable);
}
