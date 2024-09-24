package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAssignmentMapper {
    AssignmentDTO toDTO(AssignmentEntity assignmentEntity);
    AssignmentEntity toEntity(AssignmentDTO assignmentDTO);
    List<AssignmentDTO> toListDTOs(List<AssignmentEntity> entities);
    List<AssignmentEntity> toListEntities(List<AssignmentDTO> dtos);
}
