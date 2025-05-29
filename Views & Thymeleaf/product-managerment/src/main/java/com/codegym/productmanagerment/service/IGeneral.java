package com.codegym.productmanagerment.service;

import java.util.List;

public interface IGeneral<T> {
    List<T> findAll();

    void save(T T);

    T findById(int id);

    void update(int id, T T);

    void remove(int id);
}
