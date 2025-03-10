package com.admin.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductCatalogDetailsDTO {
    private Long itemId;
    private String itemName;
    private String itemDescription;
    private BigDecimal itemPrice;
    private String itemImageUrl;
    private String itemType;
    private Double discountPercentage;
    private Long categoryId;
    private Long companyId;
    private Long cuisineId;
    private Long offeringsId;
}
