package com.admin.service;

import com.admin.dto.CompanyOnboardingDTO;
import java.util.List;

public interface CompanyOnboardingService {
    List<CompanyOnboardingDTO> getAllOnboardings();
    CompanyOnboardingDTO getOnboardingById(Long onboardingId);
    CompanyOnboardingDTO createOnboarding(CompanyOnboardingDTO onboardingDTO);
    CompanyOnboardingDTO updateOnboarding(Long onboardingId, CompanyOnboardingDTO onboardingDTO);
    void deleteOnboarding(Long onboardingId);
}
