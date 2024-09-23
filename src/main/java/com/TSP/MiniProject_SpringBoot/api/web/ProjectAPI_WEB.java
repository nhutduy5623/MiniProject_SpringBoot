package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectAPI_WEB {
    @Autowired
    IProjectService projectService;

    @GetMapping(value = "/api/project")
    public ResponseDTO<ProjectDTO> homePage(@RequestParam(value = "search", required = false) String search,
                                            @RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "limit", required = false) Integer limit) {
        if(search == "")
            search = null;
        if(page == null)
            page = 1;
        if(limit == null)
            limit = 5;
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        ProjectDTO projectCondition = new ProjectDTO();
        projectCondition.setName(search);
        ResponseDTO<ProjectDTO> responseDTO = projectService.findBySpecification(projectCondition, pageRequest);
        return responseDTO;
    }

    @GetMapping(value = "/api/project/{code}")
    public ResponseDTO<ProjectDTO> findByCode(@PathVariable String code) {
        ResponseDTO<ProjectDTO> responseDTO = projectService.findOneByCode(code);
        return responseDTO;
    }
}
