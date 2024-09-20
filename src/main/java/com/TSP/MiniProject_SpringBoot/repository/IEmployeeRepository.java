package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findOneByCode(String Code);
}
