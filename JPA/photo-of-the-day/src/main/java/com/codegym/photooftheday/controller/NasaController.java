package com.codegym.photooftheday.controller;

import com.codegym.photooftheday.model.Feedback;
import com.codegym.photooftheday.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class NasaController {

    @Autowired
    private FeedbackService feedbackDao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("feedbackList", feedbackDao.getFeedbacksToday());
        model.addAttribute("feedback", new Feedback());
        return "index";
    }

    @PostMapping("/feedback")
    public String addFeedback(Feedback f) {
        feedbackDao.addFeedback(f);
        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String likeFeedback(@PathVariable("id") int id) {
        feedbackDao.likeComment(id);
        return "redirect:/home";
    }
}
