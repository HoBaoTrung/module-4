package com.codegym.blogapp.controller;

import com.codegym.blogapp.model.Category;
import com.codegym.blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/category/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/form";
    }

    @PostMapping("/save")
    public String save(Category blog) {
        categoryService.save(blog);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/form";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.remove(id);
        return "redirect:/category";
    }
}
