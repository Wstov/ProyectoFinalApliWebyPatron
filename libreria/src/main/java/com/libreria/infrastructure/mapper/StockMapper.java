/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libreria.infrastructure.mapper;

import com.libreria.domain.Stock;
import com.libreria.infrastructure.entity.ProductEntity;
import com.libreria.infrastructure.entity.StockEntity;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author Wstov
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface StockMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "dateCreated", target = "dateCreated"),
        @Mapping(source = "unitIn", target = "unitIn"),
        @Mapping(source = "unitOut", target = "unitOut"),
        @Mapping(source = "description", target = "description"),
        @Mapping(source = "balance", target = "balance")
    })

    Stock toStock(StockEntity stockEntity);
    List<Stock> toStocks(List<StockEntity> stockEntitys);
    @InheritInverseConfiguration
    StockEntity toStockEntity(Stock stock);
}
