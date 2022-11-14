package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CustomerRepo;
import com.example.ecommerce.repository.OrderRepo;
import com.example.ecommerce.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderRequest {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;

    public Order getOrderDetails(int id){
        Optional<Order> order = this.orderRepo.findById(id);
        return order.isPresent() ? order.get() : null;
    }

    public double Shippingamt(double wt, double dist){
        double total = 0;
        if(wt<2){
            if(dist<5)total = 12;
            else if(dist>=5 && dist<20)total = 15;
            else if(dist>=20 && dist<50)total = 20;
            else if(dist>=50 && dist<500)total = 50;
            else if(dist>=500 && dist<800)total = 100;
            else if(dist>800)total = 220;
        }else if(wt>=2 && wt<5){
            if(dist<5)total = 14;
            else if(dist>=5 && dist<20)total = 18;
            else if(dist>=20 && dist<50)total = 24;
            else if(dist>=50 && dist<500)total = 55;
            else if(dist>=500 && dist<800)total = 110;
            else if(dist>800)total = 250;
        }
        else if(wt>=5 && wt<20){
            if(dist<5)total = 16;
            else if(dist>=5 && dist<20)total = 25;
            else if(dist>=20 && dist<50)total = 30;
            else if(dist>=50 && dist<500)total = 80;
            else if(dist>=500 && dist<800)total = 130;
            else if(dist>800)total = 270;
        }
        else{
            if(dist<5)total = 21;
            else if(dist>=5 && dist<20)total = 35;
            else if(dist>=20 && dist<50)total = 50;
            else if(dist>=50 && dist<500)total = 90;
            else if(dist>=500 && dist<800)total = 150;
            else if(dist>800)total = 300;
        }
        return total;
    }

    public double getCartAmount(@NotNull List<Product> cart){
        double total = 0;
        double shippingCharge = 0;
        int available = 0;
        double singleCartAmount = 0;
        for(Product p : cart){
            if(p.getAvailableQuantity()>0){
                total+=p.getPrice();
                int c_pin = 123344;
                int p_pin = p.getPin();
                double shipping_distance = Math.abs(c_pin-p_pin);
                shippingCharge = Shippingamt(p.getWt(),shipping_distance);
                p.setAvailableQuantity(p.getAvailableQuantity()-1);
                productRepo.save(p);
            }

        }
        //discount section
        if(total>=1100 && total<2500)total = total*.98;
        else if(total>=2500 && total<5000)total = total*.95;
        else if(total>=5000 && total<10000)total = total*.90;
        else if(total>=10000)total = total*.80;
        return total + shippingCharge;
    }

    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }

}
