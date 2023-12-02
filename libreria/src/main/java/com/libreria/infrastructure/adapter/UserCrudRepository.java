
package com.libreria.infrastructure.adapter;


import com.libreria.infrastructure.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wstov
 */
public interface UserCrudRepository extends CrudRepository<UserEntity, Integer>{
    Optional<UserEntity> findByEmail(String email);
}
