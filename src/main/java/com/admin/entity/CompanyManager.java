package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_managers")
public class CompanyManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @Column(nullable = false)
    private String managerName;

    @Column(nullable = false, unique = true)
    private String managerLoginId;

    @Column(nullable = false)
    private String managerLoginPassword;  // **Should be hashed in real implementation**

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
