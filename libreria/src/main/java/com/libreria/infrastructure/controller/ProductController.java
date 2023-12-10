
package com.libreria.infrastructure.controller;


import com.libreria.application.service.ProductService;
import com.libreria.domain.Product;
import com.libreria.domain.User;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {
    //metodo para guardar en la base de datos
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }
    
//    Guardar los productos en la base de datos
    @PostMapping("/save-product")
    public String saveProduct(Product product,@RequestParam("img") MultipartFile multipartFile, HttpSession httpSession) throws IOException{
        //log.info("Nombre de producto: {}", product);
        productService.saveProduct(product, multipartFile, httpSession);
//        return "admin/products/create";
        return "redirect:/admin/products/show";
    }

//    Metodo para la pagina donde se muetran la lista de los productos o libros
    @GetMapping("/show")
    public String showProduct(Model model, HttpSession httpSession){
        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());
        
        User user = new User();
        user.setId(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        Iterable<Product> products = productService.getProductsByUser(user);
        model.addAttribute("books", products);
        
        return "admin/products/show";
    }
    
//    Metodo para la accion del boton de editar, haga una peticion y muestre el objeto para poder editarlo
    @GetMapping("/edit/{id}") //paso de parametros, /{parametro}= para pasar mas parametros
    public String editProduct(@PathVariable Integer id, Model model){ //@PathVariable permite trabajar con la variable que se integra en "/edit/{id}"
        Product product = productService.getProductById(id);
        //log.info("Product obtenido: {}", product);
        model.addAttribute("book", product); // con model.addAttribute se pasa el model a la vista.
        
        return "admin/products/edit";  
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin/products/show";
    }
}
