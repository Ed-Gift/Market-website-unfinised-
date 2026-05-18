package com.marketplace.controller;

import com.marketplace.model.SellerVerification;
import com.marketplace.service.SellerVerificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seller")
public class SellerVerificationController {

    private final SellerVerificationService service;

    public SellerVerificationController(
            SellerVerificationService service) {

        this.service = service;
    }

    @PostMapping("/verify")
    public SellerVerification verify(
            @RequestBody SellerVerification verification) {

        return service.save(verification);
    }
}