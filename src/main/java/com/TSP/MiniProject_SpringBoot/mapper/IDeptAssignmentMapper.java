package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDeptAssignmentMapper {
    DeptAssignmentDTO toDTO(DeptAssignmentEntity deptAssignmentEntity);
    DeptAssignmentEntity toEntity(DeptAssignmentDTO deptAssignmentDTO);
    List<DeptAssignmentDTO> toListDTOs(List<DeptAssignmentEntity> entities);
    List<DeptAssignmentEntity> toListEntities(List<DeptAssignmentDTO> dtos);
}
