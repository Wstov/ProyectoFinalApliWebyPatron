package com.libreria.infrastructure.configuration;

import com.libreria.application.repository.ProductRepository;
import com.libreria.application.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class BeanConfiguration {
    @Bean
    public ProductService productService(ProductRepository productCrudRepository){
        return new ProductService(productCrudRepository);
    }
}
