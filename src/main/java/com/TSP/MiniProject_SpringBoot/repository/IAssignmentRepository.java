package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
}
