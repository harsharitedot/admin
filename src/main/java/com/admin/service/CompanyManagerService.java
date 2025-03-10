package com.admin.service;

import com.admin.dto.CompanyManagerDTO;
import java.util.List;

public interface CompanyManagerService {
    List<CompanyManagerDTO> getAllManagers();
    CompanyManagerDTO getManagerById(Long managerId);
    CompanyManagerDTO createManager(CompanyManagerDTO managerDTO);
    CompanyManagerDTO updateManager(Long managerId, CompanyManagerDTO managerDTO);
    void deleteManager(Long managerId);
}
