package com.admin.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Offerings")
@Data
public class Offerings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offeringsId;

    @ManyToOne
    @JoinColumn(name = "cuisineId", nullable = false)
    private Cuisine cuisine;

    @ManyToOne
    @JoinColumn(name = "companyId", nullable = false)
    private Company company;

    private String offeringsName;
}