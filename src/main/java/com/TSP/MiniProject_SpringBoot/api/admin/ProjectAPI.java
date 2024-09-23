package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectAPI {

    @Autowired
    IProjectService projectService;

    @PostMapping("/api/admin/project")
    public ResponseDTO<ProjectDTO> save(@RequestBody ProjectDTO projectDTO) {
        ResponseDTO<ProjectDTO> responseDTO = projectService.save(projectDTO);
        return responseDTO;
    }

    @PutMapping("/api/admin/project")
    public ResponseDTO<ProjectDTO> update(@RequestBody ProjectDTO projectDTO) {
        ResponseDTO<ProjectDTO> responseDTO = projectService.save(projectDTO);
        return responseDTO;
    }

    @DeleteMapping("/api/admin/project")
    public void delete(@RequestBody Long[] ids) {
        projectService.delete(ids);
    }
}
