/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.PaymentEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wstov
 */
public interface PaymentCrudRepository extends CrudRepository<PaymentEntity, Integer>{
    Optional<PaymentEntity> findById(Integer id);
    
}
