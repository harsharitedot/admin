package com.admin.repository;

import com.admin.entity.DeliveryPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPricingRepository extends JpaRepository<DeliveryPricing, Long> {
}
