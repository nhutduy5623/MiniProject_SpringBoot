package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDepartmentMapper {
    DepartmentDTO toDTO(DepartmentEntity DepartmentEntity);
    DepartmentEntity toEntity(DepartmentDTO DepartmentDTO);
    List<DepartmentDTO> toListDTOs(List<DepartmentEntity> entities);
    List<DepartmentEntity> toListEntities(List<DepartmentDTO> dtos);
}