package com.example.ecommerce.service;

import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.repository.CustomerRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Integer isCustomerPresent(@NotNull Customer customer){
      return customerRepo.getCustomerByEmailAndName(customer.getEmail(), customer.getName()).getId();
    }

}
