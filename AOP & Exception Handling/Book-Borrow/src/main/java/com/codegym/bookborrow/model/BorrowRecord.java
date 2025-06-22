package com.codegym.bookborrow.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class BorrowRecord {
    @Id
    private String borrowCode;

    @ManyToOne
    private Book book;

    private LocalDateTime borrowTime;

    public BorrowRecord() {
    }

    public BorrowRecord(String borrowCode, Book book, LocalDateTime borrowTime) {
        this.borrowCode = borrowCode;
        this.book = book;
        this.borrowTime = borrowTime;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDateTime borrowTime) {
        this.borrowTime = borrowTime;
    }
}