package com.admin.dto;

import lombok.Data;

@Data
public class ProductCatalogDTO {
    private Long categoryId;
    private String categoryName;
    private Long companyId;
    private Long cuisineId;
    private Long offeringsId;
}
