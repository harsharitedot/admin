package com.admin.controller;

import com.admin.dto.CompanyOnboardingDTO;
import com.admin.service.CompanyOnboardingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-onboarding")
public class CompanyOnboardingController {

    private final CompanyOnboardingService onboardingService;

    public CompanyOnboardingController(CompanyOnboardingService onboardingService) {
        this.onboardingService = onboardingService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyOnboardingDTO>> getAllOnboardings() {
        return ResponseEntity.ok(onboardingService.getAllOnboardings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyOnboardingDTO> getOnboardingById(@PathVariable Long id) {
        return ResponseEntity.ok(onboardingService.getOnboardingById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyOnboardingDTO> createOnboarding(@RequestBody CompanyOnboardingDTO onboardingDTO) {
        return ResponseEntity.ok(onboardingService.createOnboarding(onboardingDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyOnboardingDTO> updateOnboarding(@PathVariable Long id, @RequestBody CompanyOnboardingDTO onboardingDTO) {
        return ResponseEntity.ok(onboardingService.updateOnboarding(id, onboardingDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOnboarding(@PathVariable Long id) {
        onboardingService.deleteOnboarding(id);
        return ResponseEntity.ok("Company Onboarding deleted successfully!");
    }
}
