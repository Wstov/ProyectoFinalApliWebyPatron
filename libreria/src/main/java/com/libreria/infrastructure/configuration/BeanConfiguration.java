package com.libreria.infrastructure.configuration;

import com.libreria.application.repository.ProductRepository;
import com.libreria.application.repository.StockRepository;
import com.libreria.application.service.ProductService;
import com.libreria.application.service.StockService;
import com.libreria.application.service.UploadFile;
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
    
    
}
