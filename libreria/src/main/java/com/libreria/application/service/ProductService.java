package com.libreria.application.service;


import com.libreria.application.repository.ProductRepository;
import com.libreria.domain.Product;
import com.libreria.domain.User;


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

    public Product saveProduct(Product product){
        return  productRepository.saveProduct(product);
    }

    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}
