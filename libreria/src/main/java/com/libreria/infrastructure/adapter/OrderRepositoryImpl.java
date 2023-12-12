/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.OrderRepository;
import com.libreria.domain.Order;
import com.libreria.domain.Payment;
import com.libreria.domain.ShippingAddress;
import com.libreria.domain.User;
import com.libreria.infrastructure.mapper.OrderMapper;
import com.libreria.infrastructure.mapper.PaymentMapper;
import com.libreria.infrastructure.mapper.ShippingAddressMapper;
import com.libreria.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wstov
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository{
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;
    
    private final ShippingAddressMapper shippingAddressMapper;
    private final PaymentMapper paymentMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper, UserMapper userMapper, ShippingAddressMapper shippingAddressMapper, PaymentMapper paymentMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
        this.shippingAddressMapper = shippingAddressMapper;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> getOrdersByUser(User user) {
        return orderMapper.toOrders(orderCrudRepository.findByUser(userMapper.toUserEntity(user)));
    }

    @Override
    public Iterable<Order> getAddressById(ShippingAddress shippingAddress) {
        return orderMapper.toOrders(orderCrudRepository.findByShippingAddressEntity(shippingAddressMapper.toShippingAddressEntity(shippingAddress)));
    }

    @Override
    public Iterable<Order> getPaymentMothodByUser(Payment payment) {
        return orderMapper.toOrders(orderCrudRepository.findByPaymentEntity(paymentMapper.toPaymentEntity(payment)));
    
    }


    
}
