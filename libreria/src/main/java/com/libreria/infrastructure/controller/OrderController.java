
package com.libreria.infrastructure.controller;

import com.libreria.application.service.CartService;
import com.libreria.application.service.OrderProductService;
import com.libreria.application.service.OrderService;
import com.libreria.application.service.ProductService;
import com.libreria.application.service.StockService;
import com.libreria.application.service.UserService;
import com.libreria.application.service.ValidateStock;
import com.libreria.domain.ItemCart;
import com.libreria.domain.Order;
import com.libreria.domain.OrderProduct;
import com.libreria.domain.Stock;
import com.libreria.domain.User;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Wstov
 */
@Controller
@RequestMapping("/user/order")
@Slf4j
public class OrderController {

    private final CartService cartService;
    private final UserService userService;
    
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final StockService stockService;
    private final ValidateStock validateStock;
    
    private final Integer UNIT_IN = 0;

    public OrderController(CartService cartService, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }
    
    
    @GetMapping("/buy-product")
    public String showSumaryOrder(Model model, HttpSession httpSession){
        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        model.addAttribute("id", Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        return "/user/buy";
    }
    
    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes redirectAttributes, HttpSession httpSession){
        log.info("Create Order");
        log.info("id user desde la variable de session: {}",httpSession.getAttribute("iduser").toString());
        //Usuario temporal
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        //order
        Order order =new Order();
        order.setDateCreated(LocalDateTime.now());
        order.setUser(user);
        order = orderService.createOrder(order);
        //order Product
        List<OrderProduct> orderProducts = new ArrayList<>();
        // itemcart - orderproduct
        for (ItemCart itemCart : cartService.getItemCarts()){
            orderProducts.add( new OrderProduct(productService.getProductById(itemCart.getIdProduct()),itemCart.getQuantity(),order));
        }
        
        //guardar 
        orderProducts.forEach(
                op->{
                    orderProductService.create(op);
                    Stock stock = new Stock();
                    stock.setDateCreated(LocalDateTime.now());
                    stock.setProduct(op.getProduct());
                    stock.setDescription("venta");
                    stock.setUnitIn(UNIT_IN);
                    stock.setUnitOut(op.getQuantity());
                    stockService.saveStock(validateStock.calculateBlance(stock));
                }
        );
        //vaciar carrito
        cartService.removeAllItemsCart();
        redirectAttributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString());
        return "redirect:/home"; 
    
    }
}
