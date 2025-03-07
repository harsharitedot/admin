package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CompanyOnboarding")
@Data
public class CompanyOnboarding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long onboardingId;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    private String token;
    private String headerUrl;
    private String footerUrl;
    private String companyTheme;
    private String loadingSpinnerImage;
}