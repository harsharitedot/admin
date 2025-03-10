package com.admin.service.impl;

import com.admin.dto.CompanyCuisineDTO;
import com.admin.entity.Cuisine;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.CompanyCuisineRepository;
import com.admin.service.CompanyCuisineService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyCuisineServiceImpl implements CompanyCuisineService {

    private final CompanyCuisineRepository cuisineRepository;
    private final ModelMapper modelMapper;

    public CompanyCuisineServiceImpl(CompanyCuisineRepository cuisineRepository, ModelMapper modelMapper) {
        this.cuisineRepository = cuisineRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanyCuisineDTO> getAllCuisines() {
        return cuisineRepository.findAll()
                .stream()
                .map(cuisine -> modelMapper.map(cuisine, CompanyCuisineDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyCuisineDTO getCuisineById(Long cuisineId) {
        Cuisine cuisine = cuisineRepository.findById(cuisineId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuisine Not Found"));
        return modelMapper.map(cuisine, CompanyCuisineDTO.class);
    }

    @Override
    public CompanyCuisineDTO createCuisine(CompanyCuisineDTO cuisineDTO) {
        Cuisine cuisine = modelMapper.map(cuisineDTO, Cuisine.class);
        return modelMapper.map(cuisineRepository.save(cuisine), CompanyCuisineDTO.class);
    }

    @Override
    public CompanyCuisineDTO updateCuisine(Long cuisineId, CompanyCuisineDTO cuisineDTO) {
        Cuisine existingCuisine = cuisineRepository.findById(cuisineId)
                .orElseThrow(() -> new ResourceNotFoundException("Cuisine Not Found"));
        modelMapper.map(cuisineDTO, existingCuisine);
        return modelMapper.map(cuisineRepository.save(existingCuisine), CompanyCuisineDTO.class);
    }

    @Override
    public void deleteCuisine(Long cuisineId) {
        cuisineRepository.deleteById(cuisineId);
    }
}
