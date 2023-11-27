/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.ProductEntity;
import com.libreria.infrastructure.entity.StockEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wstov
 */
public interface StockCrudRepository extends CrudRepository<StockEntity, Integer>{
    List<StockEntity> findByProductEntity(ProductEntity productEntity);
    
    
}
