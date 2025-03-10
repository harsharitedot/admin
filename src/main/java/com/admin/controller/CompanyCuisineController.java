package com.admin.controller;

import com.admin.dto.CompanyCuisineDTO;
import com.admin.service.CompanyCuisineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuisines")
public class CompanyCuisineController {

    private final CompanyCuisineService cuisineService;

    public CompanyCuisineController(CompanyCuisineService cuisineService) {
        this.cuisineService = cuisineService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyCuisineDTO>> getAllCuisines() {
        return ResponseEntity.ok(cuisineService.getAllCuisines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyCuisineDTO> getCuisineById(@PathVariable Long id) {
        return ResponseEntity.ok(cuisineService.getCuisineById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyCuisineDTO> createCuisine(@RequestBody CompanyCuisineDTO cuisineDTO) {
        return ResponseEntity.ok(cuisineService.createCuisine(cuisineDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyCuisineDTO> updateCuisine(@PathVariable Long id, @RequestBody CompanyCuisineDTO cuisineDTO) {
        return ResponseEntity.ok(cuisineService.updateCuisine(id, cuisineDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCuisine(@PathVariable Long id) {
        cuisineService.deleteCuisine(id);
        return ResponseEntity.ok("Cuisine deleted successfully!");
    }
}
