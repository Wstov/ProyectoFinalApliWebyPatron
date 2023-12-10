
package com.libreria.application.service;

import com.libreria.application.repository.UserRepository;
import com.libreria.domain.Product;
import com.libreria.domain.User;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Wstov
 */
public class UserService {
    private final UserRepository userRepository;
    private final UploadFileUser uploadFileUser;//nuevo

    public UserService(UserRepository userRepository, UploadFileUser uploadFileUser) {
        this.userRepository = userRepository;
        this.uploadFileUser = uploadFileUser;
    }

    
    // IMPLEMENTA IMAGEN
    public User createUser(User user, MultipartFile multipartFile) throws IOException{

        user.setImage(uploadFileUser.upload(multipartFile));

        return userRepository.createUser(user);
    }
    

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User findById (Integer id){
        return userRepository.findById(id);
    }


}
