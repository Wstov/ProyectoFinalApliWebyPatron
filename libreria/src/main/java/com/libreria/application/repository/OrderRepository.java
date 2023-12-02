
package com.libreria.application.repository;

import com.libreria.domain.Order;

/**
 *
 * @author Wstov
 */
public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
}
