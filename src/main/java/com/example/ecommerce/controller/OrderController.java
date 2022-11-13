package com.example.ecommerce.controller;


import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.service.OrderRequest;
import com.example.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRequest orderRequest;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

//    private Logger logger = (Logger) LoggerFactory.getLogger(Cart.class);

    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = productService.getAllProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {

        Order order = orderRequest.getOrderDetails(orderId);
        return ResponseEntity.ok(order);
    }


}
