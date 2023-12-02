
package com.libreria.application.repository;

import com.libreria.domain.Order;
import com.libreria.domain.OrderProduct;
import java.util.List;

/**
 *
 * @author Wstov
 */
public interface OrderProductRepository {
    public OrderProduct create (OrderProduct orderProduct);
    public Iterable<OrderProduct> getOrderProducts();
    public List<OrderProduct> getOrdersProductByOrder(Order order);
}
