package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.TeamDTO;
import com.TSP.MiniProject_SpringBoot.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamAPI {

    @Autowired
    ITeamService teamService;

    @PostMapping("/admin/team")
    public ResponseDTO<TeamDTO> save(@RequestBody TeamDTO teamDTO) {
        ResponseDTO<TeamDTO> responseDTO = teamService.save(teamDTO);
        return responseDTO;
    }

    @PutMapping("/admin/team")
    public ResponseDTO<TeamDTO> update(@RequestBody TeamDTO teamDTO) {
        ResponseDTO<TeamDTO> responseDTO = teamService.save(teamDTO);
        return responseDTO;
    }

    @DeleteMapping("/admin/team")
    public void delete(@RequestBody Long[] ids) {
        teamService.delete(ids);
    }

}
