/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.application.service;

import com.libreria.domain.ItemCart;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wstov
 */
public class CartService {
    private List<ItemCart> itemCarts; // Una lista de items
    private HashMap<Integer, ItemCart> itemCartHashMap; //Almacena clave valor, numva va haber claves repetidas id producto, y producto, se valida que el usuario no ingrese productos repetidos

    public CartService() {
       this.itemCartHashMap = new HashMap<>();
       this.itemCarts = new ArrayList<>();
        
    }
    
    
    //Se añade productos al carrito de compras
    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price){
        ItemCart itemCart = new ItemCart(idProduct,nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }
    
    // Se suma el valor de cada intem y retorna el valor total
    public BigDecimal getTotalCart(){
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
            
        }
        return total;
    }
    
    // Remover un item
    public void removeItemCart(Integer idProduct){
        itemCartHashMap.remove(idProduct);
        fillList();
    }
    
    //Remover todos los item
    public void removeAllItemsCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }
    
    
    // se transforman de HashMap a items
    private void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, itemCart)-> itemCarts.add(itemCart) // añade cada itemCart a itemCartHashMap
        );
    }
    
    //Metodo para imprimir por consola los productos que se agregan al carrito de compras 
    public List<ItemCart> getItemCarts(){
        return  itemCarts;
    }
}
