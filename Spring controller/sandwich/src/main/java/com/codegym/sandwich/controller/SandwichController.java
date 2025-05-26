package com.codegym.sandwich.controller;

import com.codegym.sandwich.model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("sandwich", new Sandwich());
        model.addAttribute("condimentsList", new String[]{"Lettuce","Tomato","Mustard","Sprouts"});
        return "index";
    }

    @PostMapping("/save")
    public String saveCondiments(@RequestParam(value = "condiments", required = false) String[] condiments,
                                 RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("selectedCondiments", condiments);
        return "redirect:/";
    }

}
