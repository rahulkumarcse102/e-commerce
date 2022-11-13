package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return this.productRepo.findAll();
    }

    public Product addNewProduct(Product product){
        return productRepo.save(product);
    }

    public Product updateProduct(@NotNull Product product, int id){
        product.setId(id);
        return productRepo.save(product);
    }

    public void deleteById(int id){
        productRepo.deleteById(id);
    }

    public void deleteAllProducts(){
        productRepo.deleteAll();
    }
}
