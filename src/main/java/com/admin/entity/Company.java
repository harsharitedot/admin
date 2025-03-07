package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String companyName;
    private String companyLocation;
    private String country;
    private boolean taxApplicable;
}