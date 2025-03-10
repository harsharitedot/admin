package com.admin.repository;

import com.admin.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Custom query if needed (e.g., findByCompanyName)
    Company findByCompanyName(String companyName);
}
