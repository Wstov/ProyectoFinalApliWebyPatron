/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;

import com.libreria.application.repository.OrderRepository;
import com.libreria.domain.Order;

/**
 *
 * @author Wstov
 */
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public Order createOrder(Order order ){
        return orderRepository.createOrder(order);
        
    }
    
    public Iterable<Order> getOrders(){
        return orderRepository.getOrders();
        
    }
}
