package com.libreria.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "libros")
@Data
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private UserEntity userEntity; //Crea un valor como clave foranea a la tabla UserEntity
}