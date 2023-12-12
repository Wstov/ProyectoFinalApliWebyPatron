/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.mapper;

import com.libreria.domain.Order;
import com.libreria.infrastructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author Wstov
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, PaymentMapper.class, ShippingAddressMapper.class})
public interface OrderMapper {
    @Mappings(
            {
                @Mapping(source = "id", target = "id"),
                @Mapping(source = "dateCreated", target = "dateCreated"),
                @Mapping(source = "user", target = "user"),
                @Mapping(source = "paymentEntity", target = "payment"),
                @Mapping(source = "shippingAddressEntity", target = "shippingAddress")
                
    
            }
    )
    Order toOrder(OrderEntity orderEntity);
    Iterable<Order> toOrders(Iterable<OrderEntity> orderEntities);
    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);
    
}
