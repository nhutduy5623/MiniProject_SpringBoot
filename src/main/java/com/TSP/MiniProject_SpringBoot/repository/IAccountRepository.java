package com.TSP.MiniProject_SpringBoot.repository;

import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {
}
