package com.admin.service;

import com.admin.dto.CompanyCuisineDTO;
import java.util.List;

public interface CompanyCuisineService {
    List<CompanyCuisineDTO> getAllCuisines();
    CompanyCuisineDTO getCuisineById(Long cuisineId);
    CompanyCuisineDTO createCuisine(CompanyCuisineDTO cuisineDTO);
    CompanyCuisineDTO updateCuisine(Long cuisineId, CompanyCuisineDTO cuisineDTO);
    void deleteCuisine(Long cuisineId);
}
