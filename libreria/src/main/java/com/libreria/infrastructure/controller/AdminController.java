
package com.libreria.infrastructure.controller;

import com.libreria.application.service.ProductService;
import com.libreria.domain.Product;
import com.libreria.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    
    
    @GetMapping
    public String home(Model model, HttpSession httpSession){
        User user = new User();
        user.setId(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("books", products);
        
    return "admin/admin";
    }
}
