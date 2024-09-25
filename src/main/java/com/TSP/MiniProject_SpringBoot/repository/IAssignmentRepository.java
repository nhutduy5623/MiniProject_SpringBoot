package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAssignmentRepository extends JpaRepository<AssignmentEntity, Long>, JpaSpecificationExecutor<AssignmentEntity> {
    AssignmentEntity findOneByCode(String Code);
}
