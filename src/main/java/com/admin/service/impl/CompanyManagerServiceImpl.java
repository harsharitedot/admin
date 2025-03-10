package com.admin.service.impl;

import com.admin.dto.CompanyManagerDTO;
import com.admin.entity.CompanyManager;
import com.admin.exception.ResourceNotFoundException;
import com.admin.repository.CompanyManagerRepository;
import com.admin.service.CompanyManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyManagerServiceImpl implements CompanyManagerService {

    private final CompanyManagerRepository managerRepository;
    private final ModelMapper modelMapper;

    public CompanyManagerServiceImpl(CompanyManagerRepository managerRepository, ModelMapper modelMapper) {
        this.managerRepository = managerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompanyManagerDTO> getAllManagers() {
        return managerRepository.findAll()
                .stream()
                .map(manager -> modelMapper.map(manager, CompanyManagerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyManagerDTO getManagerById(Long managerId) {
        CompanyManager manager = managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manager Not Found"));
        return modelMapper.map(manager, CompanyManagerDTO.class);
    }

    @Override
    public CompanyManagerDTO createManager(CompanyManagerDTO managerDTO) {
        CompanyManager manager = modelMapper.map(managerDTO, CompanyManager.class);
        return modelMapper.map(managerRepository.save(manager), CompanyManagerDTO.class);
    }

    @Override
    public CompanyManagerDTO updateManager(Long managerId, CompanyManagerDTO managerDTO) {
        CompanyManager existingManager = managerRepository.findById(managerId)
                .orElseThrow(() -> new ResourceNotFoundException("Manager Not Found"));
        modelMapper.map(managerDTO, existingManager);
        return modelMapper.map(managerRepository.save(existingManager), CompanyManagerDTO.class);
    }

    @Override
    public void deleteManager(Long managerId) {
        managerRepository.deleteById(managerId);
    }
}
