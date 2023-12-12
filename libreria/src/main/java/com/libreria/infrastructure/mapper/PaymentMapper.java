/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.mapper;

import com.libreria.domain.Payment;
import com.libreria.infrastructure.entity.PaymentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface PaymentMapper {
        @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "method", target = "method"),
            @Mapping(source = "cartname", target = "cartname"),
            @Mapping(source = "cartnumber", target = "cartnumber"),
            @Mapping(source = "expirationdate", target = "expirationdate"),
            @Mapping(source = "cvv", target = "cvv")
    })
    
    Payment toPayment(PaymentEntity paymentEntity);
    Iterable<Payment> toPayments (Iterable<PaymentEntity> paymentEntity);

    @InheritInverseConfiguration
    PaymentEntity toPaymentEntity(Payment payment);
}
