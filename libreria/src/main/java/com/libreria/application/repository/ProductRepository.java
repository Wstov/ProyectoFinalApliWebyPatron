package com.libreria.application.repository;

import com.libreria.domain.Product;
import com.libreria.domain.User;





//Metodos CRUD para la clase Product
public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);

}
