/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.ShippingAddressEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wstov
 */
public interface ShippingAddressCrudRepository extends CrudRepository<ShippingAddressEntity, Integer>{
    Optional<ShippingAddressEntity> findByUsername(String username);
    
}
