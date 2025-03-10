package com.admin.controller;

import com.admin.dto.DeliveryPricingDTO;
import com.admin.service.DeliveryPricingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-pricing")
public class DeliveryPricingController {

    private final DeliveryPricingService deliveryPricingService;

    public DeliveryPricingController(DeliveryPricingService deliveryPricingService) {
        this.deliveryPricingService = deliveryPricingService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryPricingDTO>> getAllPricing() {
        return ResponseEntity.ok(deliveryPricingService.getAllPricing());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryPricingDTO> getPricingById(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryPricingService.getPricingById(id));
    }

    @PostMapping
    public ResponseEntity<DeliveryPricingDTO> createPricing(@RequestBody DeliveryPricingDTO pricingDTO) {
        return ResponseEntity.ok(deliveryPricingService.createPricing(pricingDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryPricingDTO> updatePricing(@PathVariable Long id, @RequestBody DeliveryPricingDTO pricingDTO) {
        return ResponseEntity.ok(deliveryPricingService.updatePricing(id, pricingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePricing(@PathVariable Long id) {
        deliveryPricingService.deletePricing(id);
        return ResponseEntity.ok("Delivery Pricing deleted successfully!");
    }
}
