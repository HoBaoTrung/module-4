package com.codegym.bookborrow.repository;

import com.codegym.bookborrow.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
