package com.TSP.MiniProject_SpringBoot.service;

import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.TeamDTO;
import org.springframework.stereotype.Service;

@Service
public interface ITeamService {
    ResponseDTO<TeamDTO> save(TeamDTO teamDTO);
    void delete(Long[] ids);
    ResponseDTO<TeamDTO> findAll();
    ResponseDTO<TeamDTO> findOne(Long id);
    ResponseDTO<TeamDTO> findOneByCode(String code);
}
