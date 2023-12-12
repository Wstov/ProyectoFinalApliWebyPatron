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
public class Payment {
     private Integer id;
     private String method;
     private String cartname;
     private String cartnumber;
     private String expirationdate;
     private Integer cvv;
}
