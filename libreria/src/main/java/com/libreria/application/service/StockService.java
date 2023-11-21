
package com.libreria.application.service;

import com.libreria.application.repository.StockRepository;
import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import java.util.List;

/**
 *
 * @author Wstov
 */
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    
    public Stock saveStock(Stock stock){ //Metodo para guardar Stock
        return stockRepository.saveStock(stock);
    }
    
    public List<Stock> getStockByProduct(Product product){//  metodo que devuelve una lista de Stocks
        return stockRepository.getStockByProduct(product);
    }
    
    
}
