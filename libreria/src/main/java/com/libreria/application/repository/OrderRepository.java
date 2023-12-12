
package com.libreria.application.repository;

import com.libreria.domain.Order;
import com.libreria.domain.Payment;
import com.libreria.domain.ShippingAddress;
import com.libreria.domain.User;

/**
 *
 * @author Wstov
 */
public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable<Order> getOrdersByUser(User user);
    
    public Iterable<Order> getAddressById(ShippingAddress shippingAddress);
    public Iterable<Order> getPaymentMothodByUser(Payment payment);
}
