
package com.libreria.application.service;

import com.libreria.domain.User;

/**
 *
 * @author Wstov
 */

public class RegistrationService {
    
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }
    
    public void register(User user){
        userService.createUser(user);
    }
    
    
}
