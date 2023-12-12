/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;


import com.libreria.domain.ShippingAddress;
import com.libreria.application.repository.ShippingAddressRepository;

/**
 *
 * @author Wstov
 */
public class ShippingAddressService {
    private final ShippingAddressRepository shippingAddressRepository;

    public ShippingAddressService(ShippingAddressRepository sippingAddressRepository) {
        this.shippingAddressRepository = sippingAddressRepository;
    }

    public ShippingAddress creaShippingAddress(ShippingAddress shippingAddress){
        return shippingAddressRepository.createShippingAddress(shippingAddress);
    }
    
    public ShippingAddress findById(Integer id){
        return shippingAddressRepository.findById(id);
    }
    
    public ShippingAddress findByUsername(String username) {
        return shippingAddressRepository.findByUsername(username);
    }

}
