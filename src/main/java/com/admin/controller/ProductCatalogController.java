package com.admin.controller;

import com.admin.dto.ProductCatalogDTO;
import com.admin.service.ProductCatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-catalogs")
public class ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    public ProductCatalogController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCatalogDTO>> getAllCategories() {
        return ResponseEntity.ok(productCatalogService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCatalogDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(productCatalogService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<ProductCatalogDTO> createCategory(@RequestBody ProductCatalogDTO categoryDTO) {
        return ResponseEntity.ok(productCatalogService.createCategory(categoryDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCatalogDTO> updateCategory(@PathVariable Long id, @RequestBody ProductCatalogDTO categoryDTO) {
        return ResponseEntity.ok(productCatalogService.updateCategory(id, categoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        productCatalogService.deleteCategory(id);
        return ResponseEntity.ok("Product Category deleted successfully!");
    }
}
