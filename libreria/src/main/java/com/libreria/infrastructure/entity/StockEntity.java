package com.libreria.infrastructure.entity;

import com.libreria.domain.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Wstov
 */

@Entity
@Table(name = "stock")
@NoArgsConstructor
@Data
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity productEntity;
}
