/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.mapper;

import com.libreria.domain.OrderProduct;
import com.libreria.infrastructure.entity.OrderProductEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author Wstov
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrderMapper.class})
public interface OrderProductMapper {
    
    @Mappings(
            {
                @Mapping(source = "pk.productEntity", target = "product"),
                @Mapping(source = "quantity", target = "quantity"),
                @Mapping(source = "pk.orderEntity", target = "order")
            }
    )
    
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);
    Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> orderProductEntities);
    List<OrderProduct> toOrderProductsList(Iterable<OrderProductEntity> orderProductEntities); //Metodo definido
    
    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);
}
