package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssignmentAPI {
    @Autowired
    IAssignmentService assignmentService;

    @PostMapping("/api/admin/assignment")
    public ResponseDTO<AssignmentDTO> save(@RequestBody AssignmentDTO assignmentDTO) {
        ResponseDTO<AssignmentDTO> responseDTO = assignmentService.save(assignmentDTO);
        return responseDTO;
    }

    @PutMapping("/api/admin/assignment")
    public ResponseDTO<AssignmentDTO> update(@RequestBody AssignmentDTO assignmentDTO) {
        ResponseDTO<AssignmentDTO> responseDTO = assignmentService.save(assignmentDTO);
        return responseDTO;
    }

    @DeleteMapping("/api/admin/assignment")
    public void delete(@RequestBody Long[] ids) {
        assignmentService.delete(ids);
    }
}
