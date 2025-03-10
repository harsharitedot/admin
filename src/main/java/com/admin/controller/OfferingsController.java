package com.admin.controller;

import com.admin.dto.OfferingsDTO;
import com.admin.service.OfferingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offerings")
public class OfferingsController {

    private final OfferingsService offeringsService;

    public OfferingsController(OfferingsService offeringsService) {
        this.offeringsService = offeringsService;
    }

    @GetMapping
    public ResponseEntity<List<OfferingsDTO>> getAllOfferings() {
        return ResponseEntity.ok(offeringsService.getAllOfferings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferingsDTO> getOfferingById(@PathVariable Long id) {
        return ResponseEntity.ok(offeringsService.getOfferingById(id));
    }

    @PostMapping
    public ResponseEntity<OfferingsDTO> createOffering(@RequestBody OfferingsDTO offeringsDTO) {
        return ResponseEntity.ok(offeringsService.createOffering(offeringsDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferingsDTO> updateOffering(@PathVariable Long id, @RequestBody OfferingsDTO offeringsDTO) {
        return ResponseEntity.ok(offeringsService.updateOffering(id, offeringsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOffering(@PathVariable Long id) {
        offeringsService.deleteOffering(id);
        return ResponseEntity.ok("Offering deleted successfully!");
    }
}
