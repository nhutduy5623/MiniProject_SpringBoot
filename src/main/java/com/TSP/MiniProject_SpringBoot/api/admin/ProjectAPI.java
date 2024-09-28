package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProjectAPI {

    @Autowired
    IProjectService projectService;

    @PostMapping("/api/admin/project")
    public ResponseEntity<ResponseDTO<ProjectDTO>> save(@RequestBody @Valid ProjectDTO projectDTO, BindingResult bindingResult) {
        ResponseDTO<ProjectDTO> responseDTO = projectService.save(projectDTO);
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = projectService.save(projectDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/api/admin/project")
    public ResponseEntity<ResponseDTO<ProjectDTO>> update(@RequestBody @Valid ProjectDTO projectDTO, BindingResult bindingResult) {
        ResponseDTO<ProjectDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(projectDTO.getId() == null) {
            responseDTO.setStatus("400");
            responseDTO.setMessage("ID is required");
        }
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = projectService.save(projectDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/api/admin/project")
    public void delete(@RequestBody Long[] ids) {
        projectService.delete(ids);
    }
}
