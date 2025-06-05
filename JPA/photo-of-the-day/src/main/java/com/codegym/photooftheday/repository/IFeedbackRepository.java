package com.codegym.photooftheday.repository;

import com.codegym.photooftheday.model.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeedbackRepository {
    void addFeedback(Feedback f);
    List<Feedback> getFeedbacksToday();
    void likeComment(int id);
}
