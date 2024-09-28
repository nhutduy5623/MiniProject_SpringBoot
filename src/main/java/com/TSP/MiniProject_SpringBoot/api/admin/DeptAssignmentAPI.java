package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DeptAssignmentAPI {
    @Autowired
    IDeptAssignmentService deptAssignmentService;

    @PostMapping("/api/admin/dept_assignment")
    public ResponseEntity<ResponseDTO<DeptAssignmentDTO>> save(@RequestBody @Valid DeptAssignmentDTO deptAssignmentDTO, BindingResult bindingResult) {
        ResponseDTO<DeptAssignmentDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);

        responseDTO = deptAssignmentService.save(deptAssignmentDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/api/admin/dept_assignment")
    public ResponseEntity<ResponseDTO<DeptAssignmentDTO>> update(@RequestBody DeptAssignmentDTO deptAssignmentDTO, BindingResult bindingResult) {
        ResponseDTO<DeptAssignmentDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(deptAssignmentDTO.getId() == null) {
            responseDTO.setStatus("400");
            responseDTO.setMessage("ID is required");
        }
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);

        responseDTO = deptAssignmentService.save(deptAssignmentDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/api/admin/dept_assignment")
    public void delete(@RequestBody Long[] ids) {
        deptAssignmentService.delete(ids);
    }
}
