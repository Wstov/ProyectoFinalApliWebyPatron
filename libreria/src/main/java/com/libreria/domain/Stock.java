
package com.libreria.domain;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Wstov
 */
@Data
@ToString
public class Stock {
    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    private Product product;
    
}
