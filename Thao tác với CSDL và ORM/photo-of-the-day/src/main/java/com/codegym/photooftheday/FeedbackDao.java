package com.codegym.photooftheday;

import java.util.List;

public interface FeedbackDao {
    void addFeedback(Feedback f);
    List<Feedback> getFeedbacksToday();
    void likeComment(int id);
}
