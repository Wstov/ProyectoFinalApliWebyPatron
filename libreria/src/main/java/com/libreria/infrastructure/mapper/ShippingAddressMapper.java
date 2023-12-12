/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.mapper;

import com.libreria.domain.ShippingAddress;
import com.libreria.infrastructure.entity.ShippingAddressEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author Wstov
 */
@Mapper(componentModel = "spring")
public interface ShippingAddressMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "firstname", target = "firstname"),
        @Mapping(source = "lastname", target = "lastname"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "username", target = "username"),
        @Mapping(source = "firstaddress", target = "firstaddress"),
        @Mapping(source = "secondaddress", target = "secondaddress"),
        @Mapping(source = "cellphone", target = "cellphone"),
        @Mapping(source = "country", target = "country"),
        @Mapping(source = "stade", target = "stade"),
        @Mapping(source = "zip", target = "zip")
            
    })

    ShippingAddress toShippingAddress(ShippingAddressEntity shippingAddressEntity);

    Iterable<ShippingAddress> toShippingAddresses(Iterable<ShippingAddressEntity> shippingAddressEntitys);

    @InheritInverseConfiguration
    ShippingAddressEntity toShippingAddressEntity(ShippingAddress shippingAddress);

}
