
package com.libreria.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nosotros")
public class NosotrosController {
    
    @GetMapping
    public String nosotros(){
        return "nosotros/nosotros";
    }
}
