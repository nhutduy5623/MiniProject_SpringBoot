package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {
    EmployeeDTO toDTO(EmployeeEntity employeeEntity);
    EmployeeEntity toEntity(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toListDTOs(List<EmployeeEntity> entities);
    List<EmployeeEntity> toListEntities(List<EmployeeDTO> dtos);
}
