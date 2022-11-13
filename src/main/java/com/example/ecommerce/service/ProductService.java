package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepo;
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
}
