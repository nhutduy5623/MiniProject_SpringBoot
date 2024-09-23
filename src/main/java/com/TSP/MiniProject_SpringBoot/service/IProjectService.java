package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import org.springframework.data.domain.Pageable;

public interface IProjectService {
    ResponseDTO<ProjectDTO> save(ProjectDTO projectDTO);
    void delete(Long[] ids);
    ResponseDTO<ProjectDTO> findAll();
    ResponseDTO<ProjectDTO> findOne(Long id);
    ResponseDTO<ProjectDTO> findOneByCode(String code);
    ResponseDTO<ProjectDTO> findBySpecification(ProjectDTO projectCondition, Pageable pageable);
}
