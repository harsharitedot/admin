package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ProductCategory")
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "offeringsId", nullable = false)
    private Offerings offerings;

    private String categoryName;
}