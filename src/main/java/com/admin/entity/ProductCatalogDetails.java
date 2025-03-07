package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_catalog_details")
public class ProductCatalogDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(length = 500)
    private String itemDescription;

    @Column(nullable = false)
    private double itemPrice;

    @Column(nullable = true)
    private String itemImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemType itemType;  // Enum for Single/Tray/Service

    @Column(nullable = true)
    private Double discountPercentage;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCatalog category;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "cuisine_id", nullable = false)
    private Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name = "offerings_id", nullable = false)
    private Offerings offerings;
}

enum ItemType {
    SINGLE, TRAY, SERVICE;
}
