package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.TeamDTO;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import com.TSP.MiniProject_SpringBoot.mapper.ITeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamConverter {

    @Autowired
    ITeamMapper teamMapper;

    public TeamDTO toDTO(TeamEntity teamEntity) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO = teamMapper.toDTO(teamEntity);
        return teamDTO;
    }

    public TeamEntity toEntity(TeamDTO teamDTO) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity = teamMapper.toEntity(teamDTO);
        return teamEntity;
    }

    public List<TeamDTO> toListDTO(List<TeamEntity> teamEntities) {
        List<TeamDTO> teamDTOS = new ArrayList<>();
        for (TeamEntity teamEntity : teamEntities) {
            teamDTOS.add(this.toDTO(teamEntity));
        }
        return teamDTOS;
    }

    public List<TeamEntity> toListEntity(List<TeamDTO> teamDTOs) {
        List<TeamEntity> teamEntities = new ArrayList<>();
        for (TeamDTO teamDTO : teamDTOs) {
            teamEntities.add(this.toEntity(teamDTO));
        }
        return teamEntities;
    }

}
