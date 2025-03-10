package com.admin.controller;

import com.admin.dto.ProductCatalogDetailsDTO;
import com.admin.service.ProductCatalogDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-details")
public class ProductCatalogDetailsController {

    private final ProductCatalogDetailsService productDetailsService;

    public ProductCatalogDetailsController(ProductCatalogDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCatalogDetailsDTO>> getAllItems() {
        return ResponseEntity.ok(productDetailsService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCatalogDetailsDTO> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(productDetailsService.getItemById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCatalogDetailsDTO> createItem(@RequestBody ProductCatalogDetailsDTO itemDTO) {
        return ResponseEntity.ok(productDetailsService.createItem(itemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCatalogDetailsDTO> updateItem(@PathVariable Long id, @RequestBody ProductCatalogDetailsDTO itemDTO) {
        return ResponseEntity.ok(productDetailsService.updateItem(id, itemDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        productDetailsService.deleteItem(id);
        return ResponseEntity.ok("Product Item deleted successfully!");
    }
}
