
package com.libreria.infrastructure.controller;

import static com.google.cloud.Identity.user;
import com.libreria.application.service.RegistrationService;

import com.libreria.infrastructure.dto.UserDto;
import jakarta.validation.Valid;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {
    
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String register(UserDto userDto){
    return "register";
    }
    
    @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes,@RequestParam("imguser") MultipartFile multipartFile) throws IOException {
//        user.setDateCreated(LocalDateTime.now());
//        user.setUserType(UserType.USER);
//        user.setUsername(user.getEmail());

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(
                    e -> {
                        log.info("Error {}", e.getDefaultMessage());
                    }
            );
            return "register";
        }
        registrationService.register(userDto.userDtoToUser(), multipartFile);
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/register";
    }
    
    

}
