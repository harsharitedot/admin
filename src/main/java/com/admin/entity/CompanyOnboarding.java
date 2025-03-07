package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_onboarding")
public class CompanyOnboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    private String headerUrl;
    private String footerUrl;
    private String companyTheme;
    private String loadingSpinnerImage;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
