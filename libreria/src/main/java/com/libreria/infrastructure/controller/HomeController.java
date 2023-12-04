package com.libreria.infrastructure.controller;

import com.libreria.application.service.ProductService;
import com.libreria.application.service.StockService;
import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import com.libreria.domain.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
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
    @GetMapping("/aboutus")
    public String aboutus() {
        return "/home/aboutus";
    }
    
    //    Route de SERVICIOS
    @GetMapping("/services")
    public String services() {
        return "/home/services";
    }
    
    //    Route de NOSOTROS
    @GetMapping("/contact")
    public String contact() {
        return "/home/contact";
    }
    
  

    //    Route de mostrar libro
    @GetMapping("/book/{id}")
    public String showBook(@PathVariable Integer id, Model model) { //paso de parametros, /{parametro}= para pasar mas parametros
        Product product = productService.getProductById(id); //@PathVariable permite trabajar con la variable que se integra en "/edit/{id}"
        model.addAttribute("showBook", product); // con model.addAttribute se pasa el model a la vista.
        
        User user = new User();
        user.setId(1);
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("booksGenders", products);
        
        return "/home/showBook";
    }
    
    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model){
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductById(id));
        log.info("Id product: {}", id);
        log.info("stock size: {}", stocks.size());
        Integer lastBalance = stocks.get(stocks.size()-1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        return "user/productdetail";
    }

}
