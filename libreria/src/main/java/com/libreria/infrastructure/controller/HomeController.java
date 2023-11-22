package com.libreria.infrastructure.controller;

import com.libreria.application.service.ProductService;
import com.libreria.domain.Product;
import com.libreria.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping //Responde a una peticion de tipo get mapping
    public String home(Model model) {
        User user = new User();
        user.setId(1);
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("books", products);
        return "index";
    }

//    Route de NOSOTROS
    @GetMapping("/nosotros")
    public String nosotros() {
        return "/home/nosotros";
    }

    //    Route de mostrar libro
    @GetMapping("/book/{id}")
    public String showBook(@PathVariable Integer id, Model model) { //paso de parametros, /{parametro}= para pasar mas parametros
        Product product = productService.getProductById(id); //@PathVariable permite trabajar con la variable que se integra en "/edit/{id}"
        model.addAttribute("book", product); // con model.addAttribute se pasa el model a la vista.
        return "/home/showBook";
    }

}
