package com.admin.repository;

import com.admin.entity.ProductCatalogDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogDetailsRepository extends JpaRepository<ProductCatalogDetails, Long> {
}
