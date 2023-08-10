package com.ayush.onlyshoes.controller;

import com.ayush.onlyshoes.global.GlobalData;
import com.ayush.onlyshoes.model.Product;
import com.ayush.onlyshoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    ProductService productService= new ProductService();

    @GetMapping("/addToCart/{id}")
    public String addTocart(@PathVariable int id){
        GlobalData.cart.add(productService.getProductById((long) id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String getCart(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }


    @GetMapping("/cart/removeItem/{id}")
    public String removeFromCart(@PathVariable int id){
        GlobalData.cart.remove(id);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checout(Model model){
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }

}
