package com.libreria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Product {

    private Integer id;
    private String code;
    private String name;
    private String autor;
    private String editorial;
    private String genero;
    private String formato;
    private Integer publicacion;
    private String idioma;
    private String description;
    private String image;
    private BigDecimal price;
    private Boolean highlight;
    private Boolean offer;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    private User user;

    public Product() {
        this.setCode(UUID.randomUUID().toString()); //asigna un codigo aleatorio y automaticamente a la creacion de un producto
    }
}
