/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;

import com.libreria.domain.User;
import com.libreria.domain.UserType;
import com.libreria.infrastructure.dto.UserDto;

/**
 *
 * @author Wstov
 */
public class LoginService {
    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }
    
    public boolean existUser(String email){
        try {
            User user = userService.findByEmail(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    
    } 
    
    // obtenemos el id del usuario
    public Integer getUserId(String email){
        try {
            return userService.findByEmail(email).getId();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public UserType getUserType(String email){
        return userService.findByEmail(email).getUserType();
        
    }
    
    //obtenemos el usuario por email
    public User getUser(String email){
        try {
            return userService.findByEmail(email);
            
        } catch (Exception e) {
            return new User();
            
        }
    }
    
        //obtenemos el usuario por id
    public User getUser(Integer id){
        try {
            return userService.findById(id);
            
        } catch (Exception e) {
            return new User();
            
        }
    }
    
    
}
