/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.controller;

import com.libreria.application.service.LoginService;
import com.libreria.infrastructure.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login(){
        return "login";
    
    }
    
    @PostMapping
    public String access(UserDto userDto, HttpSession httpSession){
        userDto.setEmail(userDto.getUsername());       
        if(loginService.existUser(userDto)){
        httpSession.setAttribute("iduser", loginService.getUserId(userDto.getEmail()));
        if(loginService.getUserType(userDto).name().equals("ADMIN")){
            return "redirect:/admin";
        
        }else{
            return "redirect:/home";
        }
        }
        return "redirect:/home";
    }
}
