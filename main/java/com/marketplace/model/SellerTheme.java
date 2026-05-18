package com.marketplace.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SellerTheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String primaryColor;

    private String secondaryColor;

    private String bannerImage;

    @OneToOne
    private User seller;
}