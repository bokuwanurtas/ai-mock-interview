package com.aimockinterview.backend.repository;
import com.aimockinterview.backend.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TechnologyRepository extends JpaRepository<Technology,Integer> {}
