package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(nullable = false, unique = true)
    private String companyName;

    @Column(nullable = false)
    private String companyLocation;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private boolean taxApplicable;
}
