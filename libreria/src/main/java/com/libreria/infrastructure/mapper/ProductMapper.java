package com.libreria.infrastructure.mapper;


import com.libreria.domain.Product;
import com.libreria.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;




@Mapper(componentModel = "spring", uses={UserMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "autor", target = "autor"),
            @Mapping(source = "editorial", target = "editorial"),
            @Mapping(source = "genero", target = "genero"),
            @Mapping(source = "formato", target = "formato"),
            @Mapping(source = "publicacion", target = "publicacion"),
            @Mapping(source = "idioma", target = "idioma"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "price", target = "price"),
            @Mapping(source = "dateCreated", target = "dateCreated"),
            @Mapping(source = "dateUpdated", target = "dateUpdated"),
            @Mapping(source = "userEntity", target = "user"),
            @Mapping(source = "highlight", target = "highlight")

    })
    Product toProduct(ProductEntity productEntity);
    Iterable<Product> toProducts(Iterable<ProductEntity> productEntities);

    @InheritInverseConfiguration
    ProductEntity toProductEntity (Product product);

}
