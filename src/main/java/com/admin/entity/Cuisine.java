package com.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cuisine")
@Data
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineId;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    private String cuisineName;
}