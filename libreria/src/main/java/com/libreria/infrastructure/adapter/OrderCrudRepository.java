/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.OrderEntity;
import com.libreria.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author Wstov
 */
public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer>{
    public Iterable<OrderEntity> findByUser(UserEntity userEntity);
}
