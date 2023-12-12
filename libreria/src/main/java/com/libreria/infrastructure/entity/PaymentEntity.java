/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Wstov
 */
@Entity
@Table(name="payments")
@Data
@NoArgsConstructor
public class PaymentEntity {
    @Id //Define el id como campo unico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String method;
    private String cartname;
    private String cartnumber;
    private String expirationdate;
    private Integer cvv;
}
