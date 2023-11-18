package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.ProductEntity;
import com.libreria.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);
}
