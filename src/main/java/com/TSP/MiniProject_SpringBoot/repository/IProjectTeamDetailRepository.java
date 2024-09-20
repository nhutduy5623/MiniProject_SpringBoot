package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.ProjectTeamDetailEntity;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectTeamDetailRepository extends JpaRepository<ProjectTeamDetailEntity, Long> {
}
