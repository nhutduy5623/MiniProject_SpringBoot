package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import org.springframework.data.domain.Pageable;

public class DeptAssignmentService implements IDeptAssignmentService {

    @Override
    public ResponseDTO<DeptAssignmentDTO> save(DeptAssignmentDTO deptAssignmentDTO) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findAll() {
        return null;
    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findOne(Long id) {
        return null;
    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findOneByCode(String code) {
        return null;
    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findBySpecification(DeptAssignmentDTO deptAssignmentCondition, Pageable pageable) {
        return null;
    }
}
