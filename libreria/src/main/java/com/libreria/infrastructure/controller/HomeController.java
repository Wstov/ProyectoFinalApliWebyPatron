package com.libreria.infrastructure.controller;

import com.libreria.application.service.ProductService;
import com.libreria.application.service.StockService;
import com.libreria.application.service.UserService;
import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import com.libreria.domain.User;
import jakarta.servlet.http.HttpSession;
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
    private final UserService userService;
    private final StockService stockService;

    public HomeController(ProductService productService, UserService userService, StockService stockService) {
        this.productService = productService;
        this.userService = userService;
        this.stockService = stockService;
    }


    @GetMapping //Responde a una peticion de tipo get mapping
    public String home(Model model, HttpSession httpSession) {
        model.addAttribute("books", productService.getProducts());
        try {
//            model.addAttribute("id", httpSession.getAttribute("iduser").toString());
            User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
            log.info("******lA IMAGEN ES LA SIGUIENTE*****: {}", user.getImage());
            model.addAttribute("user", user);
            
        } catch (Exception e) {

        }
        return "index";
    }


    //    Route de mostrar libro en la seccion de detalles del producto
    @GetMapping("/book/{id}")
    public String showBook(@PathVariable Integer id, Model model, HttpSession httpSession) { //paso de parametros, /{parametro}= para pasar mas parametros
        Product product = productService.getProductById(id); //@PathVariable permite trabajar con la variable que se integra en "/edit/{id}"
        model.addAttribute("showBook", product); // con model.addAttribute se pasa el model a la vista.
        model.addAttribute("booksGenders", productService.getProducts());
        try {
            model.addAttribute("id_user", httpSession.getAttribute("iduser").toString());
        } catch (Exception e) {

        }
        return "/home/showBook";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model, HttpSession httpSession) {
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductById(id));
        log.info("Id product: {}", id);
        log.info("stock size: {}", stocks.size());
        Integer lastBalance = stocks.get(stocks.size() - 1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("stock", lastBalance);
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());

        } catch (Exception e) {

        }
        return "user/productdetail";
    }
    
    
//    Route de NOSOTROS
    @GetMapping("/aboutus")
    public String aboutus(Model model, HttpSession httpSession) {
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());

        } catch (Exception e) {

        }
        return "/home/aboutus";
    }

    //    Route de SERVICIOS
    @GetMapping("/services")
    public String services(Model model, HttpSession httpSession) {
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());

        } catch (Exception e) {

        }
        return "/home/services";
    }

    //    Route de NOSOTROS
    @GetMapping("/contact")
    public String contact(Model model, HttpSession httpSession) {
        try {
            model.addAttribute("id", httpSession.getAttribute("iduser").toString());

        } catch (Exception e) {

        }
        return "/home/contact";
    }

}
