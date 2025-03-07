package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "DeliveryPricing")
@Data
public class DeliveryPricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pricingId;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    private BigDecimal distance;
    private BigDecimal price;
}