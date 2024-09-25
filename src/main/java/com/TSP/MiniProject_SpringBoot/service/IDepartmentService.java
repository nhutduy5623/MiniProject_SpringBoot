package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IDepartmentService {
    ResponseDTO<DepartmentDTO> save(DepartmentDTO DepartmentDTO);
    void delete(Long[] ids);
    ResponseDTO<DepartmentDTO> findAll();
    ResponseDTO<DepartmentDTO> findOne(Long id);
    ResponseDTO<DepartmentDTO> findOneByCode(String code);
    ResponseDTO<DepartmentDTO> findBySpecification(DepartmentDTO departmentCondition, Pageable pageable);

}
