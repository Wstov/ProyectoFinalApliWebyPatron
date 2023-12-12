
package com.libreria.domain;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author Wstov
 */
@Data
public class OrderProduct {
    private Product product;
    private Integer quantity;
    private Order order;

    public OrderProduct(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }
    
    //calcular el monto total de la orden
    public BigDecimal getTotalPrice(){
        return this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
        
    }
    
}
