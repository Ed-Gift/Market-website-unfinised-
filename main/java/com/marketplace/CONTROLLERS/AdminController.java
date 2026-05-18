package com.marketplace.controller;

import com.marketplace.model.*;
import com.marketplace.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import com.marketplace.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserRepository userRepo;
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;
    private final ActivityLogRepository logRepo;
    private final AdminService adminService;

    public AdminController(UserRepository userRepo,
                           ProductRepository productRepo,
                           OrderRepository orderRepo,
                           ActivityLogRepository logRepo,
                           AdminService adminService) {

        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.logRepo = logRepo;
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public List<User> users() {
        return userRepo.findAll();
    }

    @GetMapping("/products")
    public List<Product> products() {
        return productRepo.findAll();
    }

    @GetMapping("/orders")
    public List<Order> orders() {
        return orderRepo.findAll();
    }

    @GetMapping("/logs")
    public List<ActivityLog> logs() {
        return logRepo.findAll();
    }
    @PutMapping("/approve-seller/{id}")
    public User approveSeller(@PathVariable Long id) {
        return adminService.approveSeller(id);
    }
}