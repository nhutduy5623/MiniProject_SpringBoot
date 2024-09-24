package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptAssignmentAPI_WEB {
    @Autowired
    IDeptAssignmentService deptAssignmentService;

    @GetMapping(value = "/api/dept_assignment")
    public ResponseDTO<DeptAssignmentDTO> homePage(@RequestParam(value = "search", required = false) String search,
                                               @RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "limit", required = false) Integer limit) {
        if(search == "")
            search = null;
        if(page == null)
            page = 1;
        if(limit == null)
            limit = 5;
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        DeptAssignmentDTO deptAssignmentCondition = new DeptAssignmentDTO();
        deptAssignmentCondition.setProject(new ProjectDTO());
        deptAssignmentCondition.getProject().setName(search);
        ResponseDTO<DeptAssignmentDTO> responseDTO = deptAssignmentService.findBySpecification(deptAssignmentCondition, pageRequest);
        return responseDTO;
    }
}
