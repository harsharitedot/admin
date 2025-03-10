package com.admin.service;

import com.admin.dto.ProductCatalogDTO;
import java.util.List;

public interface ProductCatalogService {
    List<ProductCatalogDTO> getAllCategories();
    ProductCatalogDTO getCategoryById(Long categoryId);
    ProductCatalogDTO createCategory(ProductCatalogDTO categoryDTO);
    ProductCatalogDTO updateCategory(Long categoryId, ProductCatalogDTO categoryDTO);
    void deleteCategory(Long categoryId);
}
