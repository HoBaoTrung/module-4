package com.codegym.currencyconverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/convert")
    public ModelAndView convertCurrency(@RequestParam double rate, @RequestParam double usd) {
        double vnd = rate * usd;
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("rate", rate);
        modelAndView.addObject("usd", usd);
        modelAndView.addObject("vnd", vnd);

        return modelAndView; // Trả về trang result.jsp
    }
}