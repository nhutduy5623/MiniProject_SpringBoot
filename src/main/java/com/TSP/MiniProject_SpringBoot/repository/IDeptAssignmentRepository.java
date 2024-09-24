package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IDeptAssignmentRepository extends JpaRepository<DeptAssignmentEntity, Long>, JpaSpecificationExecutor<DeptAssignmentEntity> {
    DeptAssignmentEntity findOneByCode(String code);
}
