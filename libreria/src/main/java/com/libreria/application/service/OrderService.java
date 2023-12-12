/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;

import com.libreria.application.repository.OrderRepository;
import com.libreria.domain.Order;
import com.libreria.domain.Payment;
import com.libreria.domain.ShippingAddress;
import com.libreria.domain.User;

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
    
    public Iterable<Order> getOrdersByUser(User user){
        return orderRepository.getOrdersByUser(user);
    }
    
    public Iterable<Order> getAddressById(ShippingAddress shippingAddress){
        return orderRepository.getAddressById(shippingAddress);
    }
    
    public Iterable<Order> getPaymentMothodByUser(Payment payment){
        return orderRepository.getPaymentMothodByUser(payment);
    }
}
