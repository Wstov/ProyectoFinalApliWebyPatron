package com.libreria.application.repository;


import com.libreria.domain.ShippingAddress;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Wstov
 */
public interface ShippingAddressRepository {
    public ShippingAddress createShippingAddress(ShippingAddress shippingAddress);
    public ShippingAddress findById(Integer id);
    public ShippingAddress findByUsername(String username);
}
