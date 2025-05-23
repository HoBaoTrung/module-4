package com.codegym.dictionaryspringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
private static final Map<String, String> dictionary = new HashMap<>();

static {
    dictionary.put("hello", "xin chào");
    dictionary.put("goodbye", "tạm biệt");
    dictionary.put("book", "sách");
    dictionary.put("computer", "máy tính");
    dictionary.put("sun", "mặt trời");
    dictionary.put("love", "tình yêu");
}

@GetMapping("/")
public String showForm() {
    return "index";
}

@PostMapping("/translate")
public ModelAndView translate(@RequestParam("word") String word) {
    String result = dictionary.get(word.toLowerCase());
    ModelAndView modelAndView = new ModelAndView("index");
    if (result != null) {
        modelAndView.addObject("result", "Nghĩa tiếng Việt: " + result);
    } else {
        modelAndView.addObject("result", "Không tìm thấy từ.");
    }
    return modelAndView;
}}