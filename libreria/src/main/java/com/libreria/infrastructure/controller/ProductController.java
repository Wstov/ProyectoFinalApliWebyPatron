
package com.libreria.infrastructure.controller;

import com.libreria.application.service.ProductService;
import com.libreria.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {
    //metodo para guardar en la base de datos
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    
    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }
    
    @PostMapping("/save-product")
    public String saveProduct(Product product ){
        log.info("Nombre de producto: {}", product);
        productService.saveProduct(product);
//        return "admin/products/create";
        return "redirect:/admin";
    }

}
