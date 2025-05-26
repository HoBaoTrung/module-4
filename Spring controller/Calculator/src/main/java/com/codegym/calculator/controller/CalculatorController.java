package com.codegym.calculator.controller;

import com.codegym.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showForm(Model model) {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("operator") String operator,
                            @RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            Model model) {
        double result;
        try {
            result = calculatorService.calculate(operator, num1, num2);
            model.addAttribute("result", result);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi khi thực hiện phép toán!");
        }
        return "index";
    }
}
