package com.codegym.blogapp.controller;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.model.Category;
import com.codegym.blogapp.service.BlogService;
import com.codegym.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping
    public String listBlogs(
            Model model,
            @RequestParam("keyword") Optional<String> keyword,
            @RequestParam("categoryId") Optional<Long> categoryId,
            @PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Blog> blogs;

        if (categoryId.isPresent()) {
            blogs = blogService.findPostsByCategory(categoryId.get(), pageable);
            Category category = categoryService.findById(categoryId.get());
            model.addAttribute("category", category);
        } else if (keyword.isPresent()) {
            blogs = blogService.searchBlogs(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        } else {
            blogs = blogService.findAll(pageable);
        }

        model.addAttribute("blogs", blogs);
        return "list";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Blog> searchBlogs(
            @RequestParam("keyword") Optional<String> keyword,
            @RequestParam("categoryId") Optional<Long> categoryId,
            @PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

        if (categoryId.isPresent()) {
            return blogService.findPostsByCategory(categoryId.get(), pageable).getContent();
        } else if (keyword.isPresent()) {
            List<Blog> result = blogService.searchBlogs(keyword.get(), pageable).getContent();
            return result;
        } else {
            return blogService.findAll(pageable).getContent();
        }
    }

    @GetMapping("/load")
    @ResponseBody
    public List<Blog> loadMoreBlogs(
            @RequestParam int page,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long categoryId,
            @PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Blog> result;

        if (categoryId != null) {
            result = blogService.findPostsByCategory(categoryId, pageable);
        } else if (keyword != null && !keyword.isEmpty()) {
            result = blogService.searchBlogs(keyword, pageable);
        } else {
            result = blogService.findAll(pageable);
        }

        return result.getContent();
    }


    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("selectedCategoryId", null);
        model.addAttribute("blog", new Blog());
        return "form";
    }

    @PostMapping("/create")
    public String save(Blog blog, @RequestParam("categoryId") Category category) {
        blog.setCategory(category);
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blog);
        model.addAttribute("selectedCategoryId", blog.getCategory().getId());
        return "form";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blogs";
    }
}

