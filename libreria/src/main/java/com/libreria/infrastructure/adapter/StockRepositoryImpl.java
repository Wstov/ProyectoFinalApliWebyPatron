
package com.libreria.infrastructure.adapter;

import com.libreria.application.repository.StockRepository;
import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import com.libreria.infrastructure.mapper.StockMapper;
import com.libreria.infrastructure.mapper.ProductMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wstov
 */
@Service
public class StockRepositoryImpl implements StockRepository{
    
    private final StockCrudRepository stockCrudRepository;
    private final StockMapper stockMapper;
    private final ProductMapper productMapper;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository, StockMapper stockMapper, ProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockMapper = stockMapper;
        this.productMapper = productMapper;
    }
            
    
    
    @Override
    public Stock saveStock(Stock stock) {
       return stockMapper.toStock(stockCrudRepository.save(stockMapper.toStockEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockMapper.toStocks(stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)));
    }
}
