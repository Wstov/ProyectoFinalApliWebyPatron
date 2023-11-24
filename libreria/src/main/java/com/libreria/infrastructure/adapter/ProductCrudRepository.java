package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.ProductEntity;
import com.libreria.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


//Crud repository es una interfas JPA que facilita trabajar con los metodos crud
//Se pasan 2 variables<tabla a la que le aplicare el CRUD><llave priamria de la tabla>
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> { 
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);

}
