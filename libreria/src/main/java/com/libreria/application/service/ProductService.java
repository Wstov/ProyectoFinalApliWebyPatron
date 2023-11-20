package com.libreria.application.service;


import com.libreria.application.repository.ProductRepository;
import com.libreria.domain.Product;
import com.libreria.domain.User;
import java.time.LocalDateTime;


public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProducts(){
        return productRepository.getProducts();
    }

    public Iterable<Product> getProductsByUser(User user){
        return productRepository.getProductsByUser(user);
    }

    public Product getProductById(Integer id){
        return productRepository.getProductById(id);
    }

//    GUARDAR Y ACTUALIZAR LA INFORMACION DE LOS LIBROS
    public Product saveProduct(Product product) {
        if (product.getId() == null) {
            User user = new User();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            return productRepository.saveProduct(product);
        
        }else{
            Product productDB= productRepository.getProductById(product.getId());
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(product);
        }
    }

    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}
