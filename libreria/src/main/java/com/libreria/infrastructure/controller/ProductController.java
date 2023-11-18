
package com.libreria.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/admin/products")
public class ProductController {
    
    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }
}
