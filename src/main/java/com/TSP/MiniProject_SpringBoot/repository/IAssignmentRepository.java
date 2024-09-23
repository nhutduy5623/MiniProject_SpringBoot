package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
