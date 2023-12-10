/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.controller;

import com.libreria.application.service.LoginService;
import com.libreria.application.service.UserService;
import com.libreria.domain.User;
import com.libreria.infrastructure.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import static java.lang.Math.log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;



    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @GetMapping
    public String login() {
        return "login";
    }

    @GetMapping("/access")
    public String access(RedirectAttributes redirectAttributes, HttpSession httpSession) {
        User user = loginService.getUser(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        redirectAttributes.addFlashAttribute("id",httpSession.getAttribute("iduser").toString()); // lleva el id del usuario logueado a la vista home(peticion a un controlador )
        
        if (loginService.existUser(user.getEmail())) {
            if (loginService.getUserType(user.getEmail()).name().equals("ADMIN")) {
                return "redirect:/admin";

            } else {
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }

}
