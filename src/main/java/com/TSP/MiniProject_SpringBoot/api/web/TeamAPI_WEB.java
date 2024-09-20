package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.TeamDTO;
import com.TSP.MiniProject_SpringBoot.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamAPI_WEB {

    @Autowired
    ITeamService teamService;

    @GetMapping(value = "/team")
    public ResponseDTO<TeamDTO> homePage() {
        ResponseDTO<TeamDTO> responseDTO = teamService.findAll();

        return responseDTO;
    }

    @GetMapping(value = "/team/{code}")
    public ResponseDTO<TeamDTO> findByCode(@PathVariable String code) {
        ResponseDTO<TeamDTO> responseDTO = teamService.findOneByCode(code);
        return responseDTO;
    }

}
