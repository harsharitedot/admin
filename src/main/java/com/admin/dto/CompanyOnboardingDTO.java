package com.admin.dto;

import lombok.Data;

@Data
public class CompanyOnboardingDTO {
    private Long id;
    private String token;
    private String headerUrl;
    private String footerUrl;
    private String companyTheme;
    private String loadingSpinnerImage;
    private Long companyId;
}
