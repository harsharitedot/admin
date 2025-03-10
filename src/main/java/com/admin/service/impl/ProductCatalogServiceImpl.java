package com.admin.service.impl;

import com.admin.dto.ProductCatalogDTO;
import com.admin.entity.ProductCatalog;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.ProductCatalogRepository;
import com.admin.service.ProductCatalogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductCatalogRepository productCatalogRepository;
    private final ModelMapper modelMapper;

    public ProductCatalogServiceImpl(ProductCatalogRepository productCatalogRepository, ModelMapper modelMapper) {
        this.productCatalogRepository = productCatalogRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductCatalogDTO> getAllCategories() {
        return productCatalogRepository.findAll()
                .stream()
                .map(category -> modelMapper.map(category, ProductCatalogDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductCatalogDTO getCategoryById(Long categoryId) {
        ProductCatalog category = productCatalogRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        return modelMapper.map(category, ProductCatalogDTO.class);
    }

    @Override
    public ProductCatalogDTO createCategory(ProductCatalogDTO categoryDTO) {
        ProductCatalog category = modelMapper.map(categoryDTO, ProductCatalog.class);
        return modelMapper.map(productCatalogRepository.save(category), ProductCatalogDTO.class);
    }

    @Override
    public ProductCatalogDTO updateCategory(Long categoryId, ProductCatalogDTO categoryDTO) {
        ProductCatalog existingCategory = productCatalogRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        modelMapper.map(categoryDTO, existingCategory);
        return modelMapper.map(productCatalogRepository.save(existingCategory), ProductCatalogDTO.class);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        productCatalogRepository.deleteById(categoryId);
    }
}
