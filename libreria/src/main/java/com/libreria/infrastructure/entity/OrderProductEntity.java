/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Wstov
 */


@Data
@Entity
@Table(name = "ordersproducts")
public class OrderProductEntity {
    
    @EmbeddedId
    private OrderProductPK pk;
    private Integer quantity;
    
}
