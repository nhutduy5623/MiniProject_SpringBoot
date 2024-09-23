package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.ProjectEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProjectMapper {
    ProjectDTO toDTO(ProjectEntity projectEntity);
    ProjectEntity toEntity(ProjectDTO projectDTO);
    List<ProjectDTO> toListDTOs(List<ProjectEntity> entities);
    List<ProjectEntity> toListEntities(List<ProjectDTO> dtos);
}
