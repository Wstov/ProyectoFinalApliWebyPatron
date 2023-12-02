/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.OrderProductRepository;
import com.libreria.domain.Order;
import com.libreria.domain.OrderProduct;
import com.libreria.infrastructure.mapper.OrderMapper;
import com.libreria.infrastructure.mapper.OrderProductMapper;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wstov
 */
@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductCrudRepository productCrudRepository; 
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;

    public OrderProductRepositoryImpl(OrderProductCrudRepository productCrudRepository, OrderMapper orderMapper, OrderProductMapper orderProductMapper) {
        this.productCrudRepository = productCrudRepository;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }


    
    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductMapper.toOrderProduct(productCrudRepository.save(orderProductMapper.toOrderProductEntity(orderProduct)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductMapper.toOrderProducts(productCrudRepository.findAll());
    }

    @Override
    public List<OrderProduct> getOrdersProductByOrder(Order order) {
        return orderProductMapper.toOrderProductsList(productCrudRepository.findByPkOrderEntity(orderMapper.toOrderEntity(order)));
    }
    
}
