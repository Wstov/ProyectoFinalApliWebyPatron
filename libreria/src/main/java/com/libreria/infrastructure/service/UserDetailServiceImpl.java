/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.service;

import com.libreria.application.service.LoginService;
import com.libreria.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wstov
 */
@Service
public class UserDetailServiceImpl  implements UserDetailsService{
    private final LoginService loginService;
    private final Integer USER_NOT_FOUND = 0;

    public UserDetailServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Integer idUser = loginService.getUserId(username);
        if (idUser != USER_NOT_FOUND) {
            User user = loginService.getUser(username);
            return org.springframework.security.core.userdetails.User.builder().username(user.getUsername()).password(user.getPassword()).roles(user.getUserType().name()).build();
        }else{
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }

}
