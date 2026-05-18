package com.marketplace.SERVICES;

import com.marketplace.model.Order;
import com.marketplace.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    private final ActivityLogService logService;
    private final OrderRepository repo;

    public OrderService(OrderRepository repo,
                        ActivityLogService logService) {

        this.repo = repo;
        this.logService = logService;
    }

    public Order placeOrder(Order order) {

        Order saved = repo.save(order);

        if(saved.getBuyer() != null){
            logService.log(
                    saved.getBuyer().getId(),
                    "Placed order ID: " + saved.getId()
            );
        }

        return saved;

    public Order markShipped(Long orderId, String code) {

            logService.log(
                    order.getBuyer().getId(),
                    "Order shipped with code: " + code
            );
    }

    public Order markDelivered(Long orderId) {

            logService.log(
                    order.getBuyer().getId(),
                    "Buyer confirmed receiving order"
            );
    }

    public Order confirmReceived(Long orderId) {

        Order order = repo.findById(orderId).orElseThrow();

        order.setReceived(true);

        return repo.save(order);
    }
}