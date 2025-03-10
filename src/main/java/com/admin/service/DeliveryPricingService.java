package com.admin.service;

import com.admin.dto.DeliveryPricingDTO;
import java.util.List;

public interface DeliveryPricingService {
    List<DeliveryPricingDTO> getAllPricing();
    DeliveryPricingDTO getPricingById(Long pricingId);
    DeliveryPricingDTO createPricing(DeliveryPricingDTO pricingDTO);
    DeliveryPricingDTO updatePricing(Long pricingId, DeliveryPricingDTO pricingDTO);
    void deletePricing(Long pricingId);
}
