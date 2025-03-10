package com.admin.service.impl;

import com.admin.dto.CompanyOnboardingDTO;
import com.admin.entity.CompanyOnboarding;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.CompanyOnboardingRepository;
import com.admin.service.CompanyOnboardingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyOnboardingServiceImpl implements CompanyOnboardingService {

    private final CompanyOnboardingRepository onboardingRepository;
    private final ModelMapper modelMapper;

    public CompanyOnboardingServiceImpl(CompanyOnboardingRepository onboardingRepository, ModelMapper modelMapper) {
        this.onboardingRepository = onboardingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanyOnboardingDTO> getAllOnboardings() {
        return onboardingRepository.findAll()
                .stream()
                .map(onboarding -> modelMapper.map(onboarding, CompanyOnboardingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyOnboardingDTO getOnboardingById(Long id) {
        CompanyOnboarding onboarding = onboardingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Onboarding Not Found"));
        return modelMapper.map(onboarding, CompanyOnboardingDTO.class);
    }

    @Override
    public CompanyOnboardingDTO createOnboarding(CompanyOnboardingDTO onboardingDTO) {
        CompanyOnboarding onboarding = modelMapper.map(onboardingDTO, CompanyOnboarding.class);
        return modelMapper.map(onboardingRepository.save(onboarding), CompanyOnboardingDTO.class);
    }

    @Override
    public CompanyOnboardingDTO updateOnboarding(Long id, CompanyOnboardingDTO onboardingDTO) {
        CompanyOnboarding existingOnboarding = onboardingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Onboarding Not Found"));
        modelMapper.map(onboardingDTO, existingOnboarding);
        return modelMapper.map(onboardingRepository.save(existingOnboarding), CompanyOnboardingDTO.class);
    }

    @Override
    public void deleteOnboarding(Long id) {
        onboardingRepository.deleteById(id);
    }
}
