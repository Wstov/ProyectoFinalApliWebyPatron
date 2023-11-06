
package com.libreria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class userController {
    
//    @GetMapping("/")
//    public String mostrarHomePage() {
//        return "home";
//    }

    @GetMapping("/nosotros")
    public String paginaNosotros() {
        return "nosotros/nosotros";
    }
}
