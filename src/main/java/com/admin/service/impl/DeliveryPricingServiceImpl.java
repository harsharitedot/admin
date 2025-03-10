package com.admin.service.impl;

import com.admin.dto.DeliveryPricingDTO;
import com.admin.entity.DeliveryPricing;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.DeliveryPricingRepository;
import com.admin.service.DeliveryPricingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryPricingServiceImpl implements DeliveryPricingService {

    private final DeliveryPricingRepository deliveryPricingRepository;
    private final ModelMapper modelMapper;

    public DeliveryPricingServiceImpl(DeliveryPricingRepository deliveryPricingRepository, ModelMapper modelMapper) {
        this.deliveryPricingRepository = deliveryPricingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DeliveryPricingDTO> getAllPricing() {
        return deliveryPricingRepository.findAll()
                .stream()
                .map(pricing -> modelMapper.map(pricing, DeliveryPricingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryPricingDTO getPricingById(Long pricingId) {
        DeliveryPricing pricing = deliveryPricingRepository.findById(pricingId)
                .orElseThrow(() -> new ResourceNotFoundException("Pricing Not Found"));
        return modelMapper.map(pricing, DeliveryPricingDTO.class);
    }

    @Override
    public DeliveryPricingDTO createPricing(DeliveryPricingDTO pricingDTO) {
        DeliveryPricing pricing = modelMapper.map(pricingDTO, DeliveryPricing.class);
        return modelMapper.map(deliveryPricingRepository.save(pricing), DeliveryPricingDTO.class);
    }

    @Override
    public DeliveryPricingDTO updatePricing(Long pricingId, DeliveryPricingDTO pricingDTO) {
        DeliveryPricing existingPricing = deliveryPricingRepository.findById(pricingId)
                .orElseThrow(() -> new ResourceNotFoundException("Pricing Not Found"));
        modelMapper.map(pricingDTO, existingPricing);
        return modelMapper.map(deliveryPricingRepository.save(existingPricing), DeliveryPricingDTO.class);
    }

    @Override
    public void deletePricing(Long pricingId) {
        deliveryPricingRepository.deleteById(pricingId);
    }
}
