
package com.libreria.application.service;

import com.libreria.domain.User;
import java.io.IOException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Wstov
 */

public class RegistrationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user, MultipartFile multipartFile) throws IOException{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.createUser(user, multipartFile);
    }  
}
