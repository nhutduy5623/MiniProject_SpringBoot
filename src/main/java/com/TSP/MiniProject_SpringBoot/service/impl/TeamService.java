package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.TeamDTO;
import com.TSP.MiniProject_SpringBoot.entity.TeamEntity;
import com.TSP.MiniProject_SpringBoot.mapper.ITeamMapper;
import com.TSP.MiniProject_SpringBoot.repository.ITeamRepository;
import com.TSP.MiniProject_SpringBoot.service.ITeamService;
import com.TSP.MiniProject_SpringBoot.service.converter.TeamConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService implements ITeamService {

    @Autowired
    ITeamMapper teamMapper;

    @Autowired
    ITeamRepository teamRepository;

    @Override
    public ResponseDTO<TeamDTO> save(TeamDTO teamDTO) {
        TeamEntity teamEntity = teamMapper.toEntity(teamDTO);
        teamEntity = teamRepository.save(teamEntity);
        teamDTO = teamMapper.toDTO(teamEntity);
        ResponseDTO<TeamDTO> responseDTO = new ResponseDTO<>("Success", teamDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            teamRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDTO<TeamDTO> findAll() {
        List<TeamEntity> teamEntities = new ArrayList<>();
        teamEntities = teamRepository.findAll();
        List<TeamDTO> teamDTOS = teamMapper.toListDTOs(teamEntities);
        ResponseDTO<TeamDTO> responseDTO = new ResponseDTO<>("Success", teamDTOS);
        return responseDTO;
    }

    @Override
    public ResponseDTO<TeamDTO> findOne(Long id) {
        TeamEntity teamEntity = teamRepository.findById(id).get();
        TeamDTO teamDTO = teamMapper.toDTO(teamEntity);
        ResponseDTO<TeamDTO> responseDTO = new ResponseDTO<>("Success", teamDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<TeamDTO> findOneByCode(String code) {
        TeamEntity teamEntity = teamRepository.findOneByCode(code);
        TeamDTO teamDTO = teamMapper.toDTO(teamEntity);
        ResponseDTO<TeamDTO> responseDTO = new ResponseDTO<>("Success", teamDTO);
        return responseDTO;
    }
}
