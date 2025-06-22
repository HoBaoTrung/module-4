package com.codegym.bookborrow.controller;

import com.codegym.bookborrow.service.MyBookService;
import com.codegym.bookborrow.service.VisitCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private MyBookService myBookService;
    @Autowired
    private VisitCounterService visitCounter;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("books", myBookService.findAll());
        visitCounter.increase();
        return "list";
    }

    @GetMapping("/book/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("book", myBookService.findById(id));
        visitCounter.increase();
        return "detail";
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam Long bookId, Model model) {

        String code = myBookService.borrowBook(bookId);
        model.addAttribute("code", code);
        return "success";

    }

    @GetMapping("/return")
    public String returnForm() {
        return "return";
    }

    @PostMapping("/return")
    public String processReturn(@RequestParam String code, Model model) {

        myBookService.returnBook(code);
        return "success";

    }
}
