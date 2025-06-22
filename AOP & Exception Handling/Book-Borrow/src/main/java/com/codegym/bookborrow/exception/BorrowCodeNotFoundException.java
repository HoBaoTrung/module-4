package com.codegym.bookborrow.exception;
public class BorrowCodeNotFoundException extends RuntimeException {
    public BorrowCodeNotFoundException(String message) {
        super(message);
    }
}
