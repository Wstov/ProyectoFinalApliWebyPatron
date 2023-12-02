
package com.libreria.application.repository;

import com.libreria.domain.User;

/**
 *
 * @author Wstov
 */
public interface UserRepository {
    public User createUser(User user);
    public User findByEmail(String email);
    public User findById(Integer id);
}
