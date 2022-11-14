package com.example.ecommerce.controller;


import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.service.OrderRequest;
import com.example.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    //List<Product> cartItems;
    List<Product> cartItems = new ArrayList<>();
    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> list = productService.getAllProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable(name = "orderId") int orderId) {
        System.out.println("we are in " + orderId);
        Order order = orderRequest.getOrderDetails(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PostMapping("/product/add")
    public Product addProductToDatabase(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProductToDatabase(@RequestBody Product product, @PathVariable int id){
        return productService.updateProduct(product,id);
    }

    @DeleteMapping("/product/deleteById/{id}")
    public void deleteProductFromDatabase(@PathVariable(name = "id") int id  ) {
        productService.deleteById(id);
        System.out.println("Your item with id "+ id + " deleted successfully");

    }

    @DeleteMapping("/product/deleteAll")
    public void deleteAllProductFromDatabase() {
        productService.deleteAllProducts();
        System.out.println("Your all product deleted successfully");

    }
    @PostMapping("/cart/{id}")
    public List<Product> orderProduct(@PathVariable int id){
         //cartItems.put(productService.getProductById(id),cartItems.getOrDefault(productService.getProductById(id),0)+1);
        cartItems.add (productService.getProductById(id));
        return cartItems;
    }
    @GetMapping("/cartItems")
    public List<Product> getCart(){
        return cartItems;
    }

    @DeleteMapping("/cart/deleteById/{id}")
    public void deleteItemFromCart(@PathVariable int id){
        for(Product p:cartItems){
            if(p.getId()==id){
                cartItems.remove(p);
                return;
            }
        }
    }

    @DeleteMapping("/deleteAllCartItem")
    public void deleteAllCartItem(){
        cartItems.clear();
        System.out.println("Your cart is empty");
    }

    @GetMapping("/cartTotal")
    public double getCartTotal(){
        return orderRequest.getCartAmount(cartItems);
    }

}

//https://github.com/rahulkumarcse102/e-commerce.git