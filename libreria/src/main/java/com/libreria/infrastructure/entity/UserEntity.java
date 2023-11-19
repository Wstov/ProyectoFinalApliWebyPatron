package com.libreria.infrastructure.entity;


import com.libreria.domain.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id //Define el id como campo unico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String cellphone;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private LocalDateTime dateCreated;

}