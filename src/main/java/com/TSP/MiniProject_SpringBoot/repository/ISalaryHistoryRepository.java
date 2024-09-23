package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.SalaryHistoryEntity;
import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaryHistoryRepository extends JpaRepository<SalaryHistoryEntity, Long> {

}
