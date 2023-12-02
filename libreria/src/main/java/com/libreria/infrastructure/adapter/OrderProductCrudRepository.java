
package com.libreria.infrastructure.adapter;

import com.libreria.infrastructure.entity.OrderEntity;
import com.libreria.infrastructure.entity.OrderProductEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Wstov
 */
public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity, Integer>{
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);
    
}
