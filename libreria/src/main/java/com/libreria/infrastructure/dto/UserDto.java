/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.dto;

import com.libreria.domain.User;
import com.libreria.domain.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author Wstov
 */
@Data
public class UserDto {
    // Validaciones para los inputs, que se este registrando la informacion correcta
    private String username;
    
    @NotBlank(message = "Nombre es requerido")
    private String firstName;
    
    @NotBlank(message = "Apellido es requerido")
    private String lastName;
    
    @Email(message = "Debe ingresar un email valido")
    private String email;
    
    @NotBlank(message = "Dirección es requerido")
    private String address;
    
    @NotBlank(message = "Celular es requerido")
    private String cellphone;
    
    @NotBlank(message = "Calve es requerido")
    private String password;
    
    
    public User userDtoToUser(){
        return new User(null, this.getEmail(),this.getFirstName(),this.getLastName(),this.getEmail(),this.getAddress(),this.getCellphone(), this.getPassword(), UserType.USER, LocalDateTime.now());
    }
}

