/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.configuration;

import com.libreria.infrastructure.service.LoginHandler;
import com.libreria.infrastructure.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Wstov
 */

@Configuration
public class SecurityConfig {
    private final UserDetailServiceImpl userDetailService;
    
    @Autowired
    private LoginHandler loginHandler;

    public SecurityConfig(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    
    
    //Seguridad
    //Filter Chain da la autorizacion segun el perfil del usuiario 
    //La autorizacion  se hace desde los niveles mas retringivos o desde los niveles en los cuales queremos restringir 
    //En este caso hemos decidido /admin y /user
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{ //Filter Chain da la autorizacion segun el perfil del usuiario 
        httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER").anyRequest().permitAll()
                .and().formLogin().loginPage("/login").successHandler(loginHandler).and().logout().logoutSuccessUrl("/close");
        
        return httpSecurity.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}