
package com.libreria.application.repository;

import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import java.util.List;

/**
 *
 * @author Wstov
 */
public interface StockRepository {
    Stock saveStock(Stock stock);    //Se almacena o guarda el Stock
    List<Stock> getStockByProduct(Product product);  //Permite buscar el stock por producto
}
