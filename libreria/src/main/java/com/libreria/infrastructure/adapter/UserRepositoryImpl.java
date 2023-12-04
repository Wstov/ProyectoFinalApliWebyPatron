
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.UserRepository;
import com.libreria.domain.User;
import com.libreria.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Wstov
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserCrudRepository userCrudRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(UserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return userMapper.toUser(userCrudRepository.save( userMapper.toUserEntity(user) ));
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(userCrudRepository.findByEmail(email).get());//.get para establecer que es un tipo de entidad
    }

    @Override
    public User findById(Integer id) {
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }
}

