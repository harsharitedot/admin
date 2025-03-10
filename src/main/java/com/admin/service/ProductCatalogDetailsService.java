package com.admin.service;

import com.admin.dto.ProductCatalogDetailsDTO;
import java.util.List;

public interface ProductCatalogDetailsService {
    List<ProductCatalogDetailsDTO> getAllItems();
    ProductCatalogDetailsDTO getItemById(Long itemId);
    ProductCatalogDetailsDTO createItem(ProductCatalogDetailsDTO itemDTO);
    ProductCatalogDetailsDTO updateItem(Long itemId, ProductCatalogDetailsDTO itemDTO);
    void deleteItem(Long itemId);
}
