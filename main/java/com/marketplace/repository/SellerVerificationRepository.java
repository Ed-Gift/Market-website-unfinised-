package com.marketplace.repository;

import com.marketplace.model.SellerVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerVerificationRepository
        extends JpaRepository<SellerVerification, Long> {
}