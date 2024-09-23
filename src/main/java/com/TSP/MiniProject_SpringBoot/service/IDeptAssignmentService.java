package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import org.springframework.data.domain.Pageable;

public interface IDeptAssignmentService {
    ResponseDTO<DeptAssignmentDTO> save(DeptAssignmentDTO deptAssignmentDTO);
    void delete(Long[] ids);
    ResponseDTO<DeptAssignmentDTO> findAll();
    ResponseDTO<DeptAssignmentDTO> findOne(Long id);
    ResponseDTO<DeptAssignmentDTO> findOneByCode(String code);
    ResponseDTO<DeptAssignmentDTO> findBySpecification(DeptAssignmentDTO deptAssignmentCondition, Pageable pageable);
}
