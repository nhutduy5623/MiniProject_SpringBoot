package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IAssignmentService {
    ResponseDTO<AssignmentDTO> save(AssignmentDTO assignmentDTO);
    void delete(Long[] ids);
    ResponseDTO<AssignmentDTO> findAll();
    ResponseDTO<AssignmentDTO> findOne(Long id);
    ResponseDTO<AssignmentDTO> findOneByCode(String code);
    ResponseDTO<AssignmentDTO> findBySpecification(AssignmentDTO assignmentCondition, Pageable pageable);
    ResponseDTO<AssignmentDTO> findBySpecification(AssignmentDTO assignmentCondition);
}
