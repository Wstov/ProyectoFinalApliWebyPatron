package com.libreria.application.service;


import com.libreria.application.repository.ProductRepository;
import com.libreria.domain.Product;
import com.libreria.domain.User;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;


public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
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
    public Product saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        if (product.getId() == null) {
            User user = new User();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            product.setImage(uploadFile.upload(multipartFile)); //Guarda el nombre de la imagen que sube el usuario
            
            return productRepository.saveProduct(product);
        
        }else{
            Product productDB= productRepository.getProductById(product.getId());
            if(multipartFile.isEmpty()){
                product.setImage(productDB.getImage());
            }else{
                // Guarda la imagen que se le envia actualmente
                // Antes se elimina la imagen que no esta agregada por defecto
                if (!productDB.getImage().equals("default.jpg")) { 
                    uploadFile.delete(productDB.getImage());
                } 
                product.setImage(uploadFile.upload(multipartFile));
            }
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
