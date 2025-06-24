package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class ShoppingController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @PostMapping("/cart/update")
    public String updateCart(@RequestParam Long id,
                             @RequestParam int quantity,@SessionAttribute("cart") Cart cart) {

            Optional<Product> productOptional = productService.findById(id);
            cart.updateProduct(productOptional.get(), quantity);

        return "redirect:/shopping-cart";
    }

    @PostMapping("/cart/remove/{id}")
    public String removeItem(@PathVariable Long id,@SessionAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

}