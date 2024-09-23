package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    ResponseDTO<AccountDTO> save(AccountDTO accountDTO);
    void delete(Long[] ids);
    ResponseDTO<AccountDTO> findAll();
    ResponseDTO<AccountDTO> findOne(Long id);
    ResponseDTO<AccountDTO> findOneByCode(String code);
    ResponseDTO<AccountDTO> findOneByEmail(String email);
    ResponseDTO<AccountDTO> findBySpecification(AccountDTO accountCondition, Pageable pageable);
}
