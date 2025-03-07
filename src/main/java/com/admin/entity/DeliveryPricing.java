package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_pricing")
public class DeliveryPricing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double distance;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
