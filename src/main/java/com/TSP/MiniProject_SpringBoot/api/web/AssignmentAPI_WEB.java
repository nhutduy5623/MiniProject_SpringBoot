package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentAPI_WEB {
    @Autowired
    IAssignmentService assignmentService;

    @GetMapping(value = "/api/assignment")
    public ResponseDTO<AssignmentDTO> homePage(@RequestParam(value = "search", required = false) String search,
                                             @RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "limit", required = false) Integer limit) {
        if(search == "")
            search = null;
        if(page == null)
            page = 1;
        if(limit == null)
            limit = 5;
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        AssignmentDTO assignmentCondition = new AssignmentDTO();
        assignmentCondition.setProject_name(search);
        ResponseDTO<AssignmentDTO> responseDTO = assignmentService.findBySpecification(assignmentCondition, pageRequest);
        return responseDTO;
    }

    @GetMapping(value = "/api/assignment/{code}")
    public ResponseDTO<AssignmentDTO> findByCode(@PathVariable String code) {
        ResponseDTO<AssignmentDTO> responseDTO = assignmentService.findOneByCode(code);
        return responseDTO;
    }

    @GetMapping(value = "/api/assignment_id/{id}")
    public ResponseDTO<AssignmentDTO> findById(@PathVariable Long id) {
        ResponseDTO<AssignmentDTO> responseDTO = assignmentService.findOne(id);
        return responseDTO;
    }
}
