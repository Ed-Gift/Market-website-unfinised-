package com.marketplace.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellerVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessName;

    private String idDocument;

    private String proofOfResidence;

    private String businessRegistration;

    private boolean verified = false;

    @OneToOne
    private User seller;
}