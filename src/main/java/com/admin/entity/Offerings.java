package com.admin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_offerings")
public class Offerings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offeringsId;

    @Column(nullable = false)
    private String offeringsName;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "cuisine_id", nullable = false)
    private Cuisine cuisine;
}
