package com.admin.service.impl;

import com.admin.dto.ProductCatalogDetailsDTO;
import com.admin.entity.ProductCatalogDetails;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.ProductCatalogDetailsRepository;
import com.admin.service.ProductCatalogDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCatalogDetailsServiceImpl implements ProductCatalogDetailsService {

    private final ProductCatalogDetailsRepository productDetailsRepository;
    private final ModelMapper modelMapper;

    public ProductCatalogDetailsServiceImpl(ProductCatalogDetailsRepository productDetailsRepository, ModelMapper modelMapper) {
        this.productDetailsRepository = productDetailsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductCatalogDetailsDTO> getAllItems() {
        return productDetailsRepository.findAll()
                .stream()
                .map(item -> modelMapper.map(item, ProductCatalogDetailsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductCatalogDetailsDTO getItemById(Long itemId) {
        ProductCatalogDetails item = productDetailsRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));
        return modelMapper.map(item, ProductCatalogDetailsDTO.class);
    }

    @Override
    public ProductCatalogDetailsDTO createItem(ProductCatalogDetailsDTO itemDTO) {
        ProductCatalogDetails item = modelMapper.map(itemDTO, ProductCatalogDetails.class);
        return modelMapper.map(productDetailsRepository.save(item), ProductCatalogDetailsDTO.class);
    }

    @Override
    public ProductCatalogDetailsDTO updateItem(Long itemId, ProductCatalogDetailsDTO itemDTO) {
        ProductCatalogDetails existingItem = productDetailsRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item Not Found"));
        modelMapper.map(itemDTO, existingItem);
        return modelMapper.map(productDetailsRepository.save(existingItem), ProductCatalogDetailsDTO.class);
    }

    @Override
    public void deleteItem(Long itemId) {
        productDetailsRepository.deleteById(itemId);
    }
}
