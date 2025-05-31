package com.codegym.springuploadfile.service;

import com.codegym.springuploadfile.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final List<Product> products;

    private ProductService() {
        products = new ArrayList<>();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.set(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
