package com.codegym.bookborrow.controller;

import com.codegym.bookborrow.exception.BookUnavailableException;
import com.codegym.bookborrow.exception.BorrowCodeNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookUnavailableException.class)
    public String handleBookUnavailable(BookUnavailableException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(BorrowCodeNotFoundException.class)
    public String handleCodeNotFound(BorrowCodeNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralError(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Lỗi không xác định: " + ex.getMessage());
        return "error";
    }
}
