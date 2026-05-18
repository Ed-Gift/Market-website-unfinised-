package com.marketplace.service;

import com.marketplace.model.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    // Calculate seller payment after 8% fee
    public double calculateSellerAmount(double amount){

        double fee = amount * 0.08;

        return amount - fee;
    }

    // Check if seller can receive money
    public boolean canReleaseFunds(Order order){

        // Buyer confirmed receiving
        if(order.isReceived()){
            return true;
        }

        // Auto release after 48 hours
        if(order.getDeliveredAt() != null){

            long diff =
                    new Date().getTime()
                            - order.getDeliveredAt().getTime();

            long hoursPassed =
                    TimeUnit.MILLISECONDS.toHours(diff);

            return hoursPassed >= 48;
        }

        return false;
    }

    // Release payment
    public void releaseMoney(Order order){

        double sellerAmount =
                calculateSellerAmount(order.getAmount());

        System.out.println(
                "Released R"
                        + sellerAmount
                        + " to seller"
        );
    }
}