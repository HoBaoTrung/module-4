package com.codegym.bookborrow.service;

import com.codegym.bookborrow.exception.BookUnavailableException;
import com.codegym.bookborrow.exception.BorrowCodeNotFoundException;
import com.codegym.bookborrow.model.Book;
import com.codegym.bookborrow.model.BorrowRecord;
import com.codegym.bookborrow.repository.BookRepository;
import com.codegym.bookborrow.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MyBookService {
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private BorrowRecordRepository recordRepo;

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public String borrowBook(Long bookId) {
        Book book = findById(bookId);
        if (book.getAvailableCopies() <= 0) {
            throw new BookUnavailableException("Sách đã hết");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepo.save(book);

        String code = String.format("%05d", new Random().nextInt(100000));
        BorrowRecord record = new BorrowRecord();
        record.setBorrowCode(code);
        record.setBook(book);
        record.setBorrowTime(LocalDateTime.now());
        recordRepo.save(record);

        return code;
    }

    public void returnBook(String code) {
        BorrowRecord record = recordRepo.findById(code)
                .orElseThrow(() -> new BorrowCodeNotFoundException("Mã không tồn tại"));
        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepo.save(book);
        recordRepo.delete(record);
    }
}
