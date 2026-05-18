package com.marketplace.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String deliveryCode;

    private double amount;

    private boolean received = false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveredAt;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private Product product;
}