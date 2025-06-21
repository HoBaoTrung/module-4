package com.codegym.photooftheday;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadFeedbackException.class)
    public String handleBadFeedback(BadFeedbackException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "bad-feedback";
    }
}