package com.admin.repository;

import com.admin.entity.Offerings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferingsRepository extends JpaRepository<Offerings, Long> {
}
