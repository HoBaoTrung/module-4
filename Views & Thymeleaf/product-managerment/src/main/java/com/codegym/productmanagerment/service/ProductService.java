package com.codegym.productmanagerment.service;

import com.codegym.productmanagerment.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService implements IGeneral<Product>{
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        // Thêm dữ liệu mẫu
        products.put(1, new Product(1, "Laptop", 1000.0, 10));
        products.put(2, new Product(2, "Smartphone", 500.0, 20));
        products.put(3, new Product(3, "Tablet", 300.0, 15));
        products.put(4, new Product(4, "Headphones", 50.0, 50));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product T) {
        this.products.put(T.getId(), T);
    }

    @Override
    public Product findById(int id) {
        return this.products.get(id);
    }

    @Override
    public void update(int id, Product T) {
        this.products.put(id, T);
    }

    @Override
    public void remove(int id) {
        this.products.remove(id);
    }

    public List<Product> getProductsByName(String searchName) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
