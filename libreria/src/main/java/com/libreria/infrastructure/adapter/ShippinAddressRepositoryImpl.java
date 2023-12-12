/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.ShippingAddressRepository;
import com.libreria.domain.ShippingAddress;
import com.libreria.infrastructure.mapper.ShippingAddressMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wstov
 */
@Repository
public class ShippinAddressRepositoryImpl implements ShippingAddressRepository{
    private final ShippingAddressCrudRepository shippingAddressCrudRepository;
    private final ShippingAddressMapper shippingAddressMapper;

    public ShippinAddressRepositoryImpl(ShippingAddressCrudRepository shippingAddressCrudRepository, ShippingAddressMapper shippingAddressMapper) {
        this.shippingAddressCrudRepository = shippingAddressCrudRepository;
        this.shippingAddressMapper = shippingAddressMapper;
    }

    @Override
    public ShippingAddress createShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressMapper.toShippingAddress(shippingAddressCrudRepository.save(shippingAddressMapper.toShippingAddressEntity(shippingAddress)));
    }

    @Override
    public ShippingAddress findById(Integer id) {
        return shippingAddressMapper.toShippingAddress(shippingAddressCrudRepository.findById(id).get());
    }

    @Override
    public ShippingAddress findByUsername(String username) {
        return shippingAddressMapper.toShippingAddress(shippingAddressCrudRepository.findByUsername(username).get());
    }

}
