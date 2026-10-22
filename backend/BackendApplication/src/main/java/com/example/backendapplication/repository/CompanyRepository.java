package com.aimockinterview.backend.repository;
import com.aimockinterview.backend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CompanyRepository extends JpaRepository<Company,Integer> {}
