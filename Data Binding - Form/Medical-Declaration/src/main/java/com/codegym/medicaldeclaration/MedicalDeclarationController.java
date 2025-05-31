package com.codegym.medicaldeclaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/medical")
public class MedicalDeclarationController {

    @Autowired
    private MedicalDeclarationService service;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("declaration", new MedicalDeclaration());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("declaration") MedicalDeclaration declaration,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        service.save(declaration);
        return "redirect:/medical/list";
    }

    @GetMapping("/list")
    public String listDeclarations(Model model) {
        model.addAttribute("declarations", service.findAll());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        MedicalDeclaration declaration = service.findById(id);
        model.addAttribute("declaration", declaration);
        return "form";
    }

    @PostMapping("/update")
    public String updateForm(@ModelAttribute("declaration") MedicalDeclaration declaration,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }
        service.save(declaration);
        return "redirect:/medical/list";
    }
}

