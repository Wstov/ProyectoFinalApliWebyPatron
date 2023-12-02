package com.libreria.infrastructure.configuration;

import com.libreria.application.repository.OrderProductRepository;
import com.libreria.application.repository.OrderRepository;
import com.libreria.application.repository.ProductRepository;
import com.libreria.application.repository.StockRepository;
import com.libreria.application.repository.UserRepository;
import com.libreria.application.service.OrderProductService;
import com.libreria.application.service.OrderService;
import com.libreria.application.service.ProductService;
import com.libreria.application.service.RegistrationService;
import com.libreria.application.service.StockService;
import com.libreria.application.service.UploadFile;
import com.libreria.application.service.UserService;
import com.libreria.application.service.ValidateStock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



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
    public UserService userService(UserRepository userRepository){
        return  new UserService(userRepository);
    }

    
    @Bean
    public RegistrationService registrationService(UserService userService){
        return new RegistrationService(userService);
    }
    
}
