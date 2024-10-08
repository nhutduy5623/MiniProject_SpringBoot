package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ExcelDTO.EmployeeExcel;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {
    ResponseDTO<EmployeeDTO> save(EmployeeDTO employeeDTO);
    void delete(Long[] ids);
    ResponseDTO<EmployeeDTO> findAll();
    ResponseDTO<EmployeeDTO> findOne(Long id);
    ResponseDTO<EmployeeDTO> findOneByCode(String code);
    ResponseDTO<EmployeeDTO> findBySpecification(EmployeeDTO employeeCondition, Pageable pageable);
}
