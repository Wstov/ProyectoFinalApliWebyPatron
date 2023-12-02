
package com.libreria.application.service;

import com.libreria.application.repository.UserRepository;
import com.libreria.domain.User;

/**
 *
 * @author Wstov
 */
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user){
    return userRepository.createUser(user); 
    
    }
    
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    
    public User findById(Integer id){
        return userRepository.findById(id);
    }
    
}
