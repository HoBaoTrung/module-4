package com.codegym.springsecurity;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        // Get authenticated username from Principal
        System.out.println(principal.getName());
        return new ModelAndView("index");
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        // Get authenticated username from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return new ModelAndView("admin");
    }
}