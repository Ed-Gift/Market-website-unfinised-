package com.marketplace.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating; // 1 to 5 stars

    private String comment;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User buyer;
}