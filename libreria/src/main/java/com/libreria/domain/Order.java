
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
    private String addressTow;
    private String country;
    private String state;
    private String zip;
    
    
    public void addOrdersProduct(List<OrderProduct> orderProduct){
        this.setOrderProduct(orderProduct);
    }
    
    public BigDecimal getTotalOrderPrice(){
        return getOrderProduct().stream().map(
                p->p.getTotalPrice()
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
        
    }
}
