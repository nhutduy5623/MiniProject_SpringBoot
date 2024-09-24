package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptAssignmentAPI {
    @Autowired
    IDeptAssignmentService deptAssignmentService;

    @PostMapping("/api/admin/dept_assignment")
    public ResponseDTO<DeptAssignmentDTO> save(@RequestBody DeptAssignmentDTO deptAssignmentDTO) {
        ResponseDTO<DeptAssignmentDTO> responseDTO = deptAssignmentService.save(deptAssignmentDTO);
        return responseDTO;
    }

    @PutMapping("/api/admin/dept_assignment")
    public ResponseDTO<DeptAssignmentDTO> update(@RequestBody DeptAssignmentDTO deptAssignmentDTO) {
        ResponseDTO<DeptAssignmentDTO> responseDTO = deptAssignmentService.save(deptAssignmentDTO);
        return responseDTO;
    }

    @DeleteMapping("/api/admin/dept_assignment")
    public void delete(@RequestBody Long[] ids) {
        deptAssignmentService.delete(ids);
    }
}
