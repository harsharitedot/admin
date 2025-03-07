package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_cuisines")
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuisineId;

    @Column(nullable = false)
    private String cuisineName;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
