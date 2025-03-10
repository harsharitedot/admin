package com.admin.dto;

import lombok.Data;

@Data
public class CompanyDTO {
    private Long companyId;
    private String companyName;
    private String companyLocation;
    private String country;
    private boolean taxApplicable;
}

