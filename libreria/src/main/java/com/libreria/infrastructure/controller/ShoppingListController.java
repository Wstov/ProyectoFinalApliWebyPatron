/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.infrastructure.controller;

import com.libreria.application.service.OrderProductService;
import com.libreria.application.service.OrderService;
import com.libreria.application.service.UserService;
import com.libreria.domain.Order;
import com.libreria.domain.OrderProduct;
import com.libreria.domain.User;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/cart/shopping")
public class ShoppingListController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderProductService orderProductService;

    public ShoppingListController(OrderService orderService, UserService userService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderProductService = orderProductService;
    }

    
    @GetMapping
    public String showShoppingList(Model model, HttpSession httpSession){
        User user = userService.findById(Integer.parseInt( httpSession.getAttribute("iduser").toString()));
        List<Order> newListOrder = new ArrayList<>();
        
        
        Iterable<Order> orders = orderService.getOrdersByUser(user);
        for (Order order: orders) {
            newListOrder.add(getOrdersProducts(order));
            
        }
        model.addAttribute("id",Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("orders", newListOrder);
        
        return "user/shoppinglist";
    }
    
    
    private Order getOrdersProducts(Order order){
        Iterable<OrderProduct> orderProducts = orderProductService.getOrderProductsByOrder(order);
        order.addOrdersProduct((List<OrderProduct>)orderProducts);
        return order;
    }
}
