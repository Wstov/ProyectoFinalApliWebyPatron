
package com.libreria.infrastructure.controller;

import com.libreria.application.service.StockService;
import com.libreria.application.service.ValidateStock;
import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/admin/products/stock")
public class StockController {
    
    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model){
        Product product = new Product();
        product.setId(id);
        List<Stock> stocks = stockService.getStockByProduct(product);
        model.addAttribute("stocks", stocks); //se pasa la List a la vista
        model.addAttribute("idProduct",id); //se pasa la List a la vista
        
        return "admin/stock/showStock";
    }
    
    
    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idProduct", id);
        
        return "admin/stock/createStock";
    }
    
    @PostMapping("/save-unit-product")
    public String save( Stock stock, @RequestParam("idProduct") Integer idProduct){
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("inventario");
        Product product = new Product();
        product.setId(idProduct);
        stock.setProduct(product);
        stockService.saveStock(validateStock.calculateBlance(stock));
        return "redirect:/admin/products/show";
    }
    
}
