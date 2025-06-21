package com.codegym.photooftheday;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class NasaController {

    @Autowired
    private FeedbackDao feedbackDao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("feedbackList", feedbackDao.getFeedbacksToday());
        model.addAttribute("feedback", new Feedback());
        return "index";
    }

    @PostMapping("/feedback")
    public String addFeedback(Feedback f) {
        if (BadWordFilter.containsBadWords(f.getComment())) {
            throw new BadFeedbackException("Feedback chứa từ ngữ không phù hợp", f);
        }
        feedbackDao.addFeedback(f);
        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String likeFeedback(@PathVariable("id") int id) {
        feedbackDao.likeComment(id);
        return "redirect:/home";
    }
}
