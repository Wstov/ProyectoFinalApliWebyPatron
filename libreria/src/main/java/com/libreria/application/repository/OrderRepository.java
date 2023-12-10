
package com.libreria.application.repository;

import com.libreria.domain.Order;
import com.libreria.domain.User;

/**
 *
 * @author Wstov
 */
public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable<Order> getOrdersByUser(User user);
}
