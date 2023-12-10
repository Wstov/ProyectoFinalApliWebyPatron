
package com.libreria.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Wstov
 */

@Data
public class Order {
    private Integer id;
    private LocalDateTime dateCreated;
    private List<OrderProduct> orderProduct;
    private User user;
 
    
    
    public void addOrdersProduct(List<OrderProduct> orderProduct){
        this.setOrderProduct(orderProduct);
    }
    
    public BigDecimal getTotalOrderPrice(){
        return getOrderProduct().stream().map(
                p->p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
        
    }
}
