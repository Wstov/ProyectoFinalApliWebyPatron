package com.libreria.application.service;

import com.libreria.domain.Product;
import com.libreria.domain.Stock;
import java.util.List;

/**
 *
 * @author Wstov
 */
public class ValidateStock {

    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }

    private boolean existBalance(Product product) {
        List<Stock> stockList = stockService.getStockByProduct(product);//Obtiene todos los inventarios por producto
        return stockList.isEmpty() ? false : true;

    }

    // Suma a nivel de saldo de producto por ingresos o salidas
    public Stock calculateBlance(Stock stock) {
        if (stock.getUnitIn() != 0) {
            if (existBalance(stock.getProduct())) {
                List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
                Integer balance = stockList.get(stockList.size() - 1).getBalance();
                stock.setBalance(balance + stock.getUnitIn());
            } else {
                stock.setBalance(stock.getUnitIn());
            }
        } else {
            List<Stock> stockList = stockService.getStockByProduct(stock.getProduct());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance - stock.getUnitOut());
        }

        return stock;
    }
}
