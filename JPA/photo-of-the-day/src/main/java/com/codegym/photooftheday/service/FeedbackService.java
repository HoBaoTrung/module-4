package com.codegym.photooftheday.service;

import com.codegym.photooftheday.model.Feedback;
import com.codegym.photooftheday.repository.IFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public void addFeedback(Feedback feedback) {
         feedbackRepository.addFeedback(feedback);
    }

    @Override
    public List<Feedback> getFeedbacksToday() {
        return feedbackRepository.getFeedbacksToday();
    }

    @Override
    public void likeComment(int id) {
        feedbackRepository.likeComment(id);
    }

//    @Override
//    public Feedback findById(int id) {
//        return feedbackRepository.findById(id);
//    }
}
