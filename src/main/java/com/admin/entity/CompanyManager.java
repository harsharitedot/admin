package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CompanyManager")
@Data
public class CompanyManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    private String managerName;
    private String managerLoginId;
    private String managerLoginPassword;
}