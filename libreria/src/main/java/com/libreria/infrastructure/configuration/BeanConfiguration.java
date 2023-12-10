package com.libreria.infrastructure.configuration;

import com.libreria.application.repository.OrderProductRepository;
import com.libreria.application.repository.OrderRepository;
import com.libreria.application.repository.ProductRepository;
import com.libreria.application.repository.StockRepository;
import com.libreria.application.repository.UserRepository;
import com.libreria.application.service.CartService;
import com.libreria.application.service.LoginService;
import com.libreria.application.service.LogoutService;
import com.libreria.application.service.OrderProductService;
import com.libreria.application.service.OrderService;
import com.libreria.application.service.ProductService;
import com.libreria.application.service.RegistrationService;
import com.libreria.application.service.StockService;
import com.libreria.application.service.UploadFile;
import com.libreria.application.service.UploadFileUser;
import com.libreria.application.service.UserService;
import com.libreria.application.service.ValidateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;


@Configuration
public class BeanConfiguration {
    @Bean // anotacion bean se inyecta en cualquier parte del proyecto
    public ProductService productService(ProductRepository productCrudRepository, UploadFile uploadFile){
        return new ProductService(productCrudRepository, uploadFile);
    }
    
    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();    
    }
    
    //    ------------ se agrego uploadFileUser
    @Bean
    public UserService userService(UserRepository userRepository, UploadFileUser uploadFileUser){
        return  new UserService(userRepository, uploadFileUser );
    }
    
    @Bean
    public UploadFileUser uploadFileUser(){
        return new UploadFileUser();
    }

    @Bean
    public StockService stockService(StockRepository stockRepository){
        return new StockService(stockRepository);
    }
    
    @Bean
    public ValidateStock validateStock(StockService stockService){
        return new ValidateStock(stockService);
    }
    
    @Bean
    public OrderService orderServece(OrderRepository orderRepository){
        return new OrderService(orderRepository);
    }
    
    @Bean
    public OrderProductService orderProductService(OrderProductRepository orderProductRepository){
        return new OrderProductService(orderProductRepository);
    }
    

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)//corige el comportamiento por defecto de los beans que son singled
    public CartService cartSevice() {
        return new CartService();
        
    }
    
    @Bean
    public RegistrationService registrationService(UserService userService,PasswordEncoder passwordEncoder){
        return new RegistrationService(userService, passwordEncoder);
    }
    
    @Bean 
    public LoginService loginService(UserService userService){
        return new LoginService(userService);
    }
    
    @Bean
    public LogoutService logoutService(){
        return new LogoutService();
    
    }
    
  
}
