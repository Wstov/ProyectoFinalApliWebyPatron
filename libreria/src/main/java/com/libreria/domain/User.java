package com.libreria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data //con esta anotacion tenemos los get set
@AllArgsConstructor //Define un constructor con todos los atriburos
@NoArgsConstructor //Denine un constructor sin los argumentos
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;
    private UserType userType;
    private LocalDateTime dateCreated;
}
