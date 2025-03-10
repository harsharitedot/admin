package com.admin.service;

import com.admin.dto.CompanyDTO;
import java.util.List;

public interface CompanyService {
    List<CompanyDTO> getAllCompanies();
    CompanyDTO getCompanyById(Long companyId);
    CompanyDTO createCompany(CompanyDTO companyDTO);
    CompanyDTO updateCompany(Long companyId, CompanyDTO companyDTO);
    void deleteCompany(Long companyId);
}
