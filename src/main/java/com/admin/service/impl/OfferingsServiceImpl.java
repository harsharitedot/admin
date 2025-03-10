package com.admin.service.impl;

import com.admin.dto.OfferingsDTO;
import com.admin.entity.Offerings;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.OfferingsRepository;
import com.admin.service.OfferingsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferingsServiceImpl implements OfferingsService {

    private final OfferingsRepository offeringsRepository;
    private final ModelMapper modelMapper;

    public OfferingsServiceImpl(OfferingsRepository offeringsRepository, ModelMapper modelMapper) {
        this.offeringsRepository = offeringsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferingsDTO> getAllOfferings() {
        return offeringsRepository.findAll()
                .stream()
                .map(offering -> modelMapper.map(offering, OfferingsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferingsDTO getOfferingById(Long offeringId) {
        Offerings offering = offeringsRepository.findById(offeringId)
                .orElseThrow(() -> new ResourceNotFoundException("Offering Not Found"));
        return modelMapper.map(offering, OfferingsDTO.class);
    }

    @Override
    public OfferingsDTO createOffering(OfferingsDTO offeringsDTO) {
        Offerings offering = modelMapper.map(offeringsDTO, Offerings.class);
        return modelMapper.map(offeringsRepository.save(offering), OfferingsDTO.class);
    }

    @Override
    public OfferingsDTO updateOffering(Long offeringId, OfferingsDTO offeringsDTO) {
        Offerings existingOffering = offeringsRepository.findById(offeringId)
                .orElseThrow(() -> new ResourceNotFoundException("Offering Not Found"));
        modelMapper.map(offeringsDTO, existingOffering);
        return modelMapper.map(offeringsRepository.save(existingOffering), OfferingsDTO.class);
    }

    @Override
    public void deleteOffering(Long offeringId) {
        offeringsRepository.deleteById(offeringId);
    }
}
