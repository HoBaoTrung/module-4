package com.codegym.photooftheday.service;

import com.codegym.photooftheday.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    void addFeedback(Feedback feedback);
    List<Feedback> getFeedbacksToday();
    void likeComment(int id);
//    Feedback findById(int id);
}
