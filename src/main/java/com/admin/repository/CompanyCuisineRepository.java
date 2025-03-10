package com.admin.repository;

import com.admin.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyCuisineRepository extends JpaRepository<Cuisine, Long> {
}
