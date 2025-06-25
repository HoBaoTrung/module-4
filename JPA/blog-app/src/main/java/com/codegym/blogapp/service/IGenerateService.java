package com.codegym.blogapp.service;

import java.util.List;

public interface IGenerateService <T> {
    List<T> findAll();

    T save(T t);

    T findById(Long id);

    void remove(Long id);
}
