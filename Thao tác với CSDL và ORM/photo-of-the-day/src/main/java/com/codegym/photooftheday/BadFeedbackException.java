package com.codegym.photooftheday;
public class BadFeedbackException extends RuntimeException {
    private final Feedback feedback;

    public BadFeedbackException(String message, Feedback feedback) {
        super(message);
        this.feedback = feedback;
    }

    public Feedback getFeedback() {
        return feedback;
    }
}