package com.admin.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "ProductCatalog")
@Data
public class ProductCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private ProductCategory category;

    private String itemName;
    private String itemDescription;
    private BigDecimal itemPrice;
    private String itemImageUrl;
    private String itemType;
    private BigDecimal discountPercentage;
}