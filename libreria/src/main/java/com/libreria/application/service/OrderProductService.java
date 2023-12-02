
package com.libreria.application.service;

import com.libreria.application.repository.OrderProductRepository;
import com.libreria.domain.Order;
import com.libreria.domain.OrderProduct;
import java.util.List;

/**
 *
 * @author Wstov
 */
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }
    
    public OrderProduct create(OrderProduct orderProduct){
        return orderProductRepository.create(orderProduct);
        
    }
    
    public Iterable<OrderProduct> getOrderProduct(){
        return orderProductRepository.getOrderProducts();
    }
    
    public List<OrderProduct> getOrderProductsByOrder(Order order){
        return orderProductRepository.getOrdersProductByOrder(order);
        
    }
    
}
