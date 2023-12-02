
package com.libreria.infrastructure.controller;

import com.libreria.application.service.RegistrationService;
import com.libreria.domain.User;
import com.libreria.domain.UserType;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String register(){
    return "register";
    }
    
    @PostMapping
    public String registerUser(User user){
        user.setDateCreated(LocalDateTime.now());
        user.setUserType(UserType.USER);
        user.setUsername(user.getEmail());
        registrationService.register(user);
        
        return "redirect:/register";
    }
}
