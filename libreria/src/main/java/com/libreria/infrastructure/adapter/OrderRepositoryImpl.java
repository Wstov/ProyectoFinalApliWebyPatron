/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.OrderRepository;
import com.libreria.domain.Order;
import com.libreria.infrastructure.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wstov
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
    }
     
    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }
    
}
