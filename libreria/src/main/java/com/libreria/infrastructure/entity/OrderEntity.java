
package com.libreria.infrastructure.entity;

import com.libreria.domain.Payment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import lombok.Data;

/**
 *
 * @author Wstov
 */
@Entity
@Table(name="orders")
@Data
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    @ManyToOne
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentEntity paymentEntity;
    
    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private ShippingAddressEntity shippingAddressEntity;
    
}
