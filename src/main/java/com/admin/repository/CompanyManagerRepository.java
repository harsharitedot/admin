package com.admin.repository;

import com.admin.entity.CompanyManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyManagerRepository extends JpaRepository<CompanyManager, Long> {
    CompanyManager findByManagerLoginId(String managerLoginId);
}
