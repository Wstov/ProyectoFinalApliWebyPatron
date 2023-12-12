/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wstov
 */
@Data //con esta anotacion tenemos los get set
@AllArgsConstructor //Define un constructor con todos los atriburos
@NoArgsConstructor //Denine un constructor sin los argumentos
public class ShippingAddress {
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String firstaddress;
    private String secondaddress;
    private String cellphone;
    private String country;
    private String stade;
    private Integer zip;
    
}
