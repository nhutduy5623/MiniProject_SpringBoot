package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.TeamDTO;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDTO toDTO(TeamEntity TeamEntity);
    TeamEntity toEntity(TeamDTO teamDTO);
    List<TeamDTO> toListDTOs(List<TeamEntity> entities);
    List<TeamEntity> toListEntities(List<TeamDTO> dtos);
}
