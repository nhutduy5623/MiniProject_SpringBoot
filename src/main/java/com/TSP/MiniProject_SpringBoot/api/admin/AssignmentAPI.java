package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class AssignmentAPI {
    @Autowired
    IAssignmentService assignmentService;

    @PostMapping("/api/admin/assignment")
    public ResponseEntity<ResponseDTO<AssignmentDTO>> save(@RequestBody AssignmentDTO assignmentDTO, BindingResult bindingResult) {
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = assignmentService.save(assignmentDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/api/admin/assignment")
    public ResponseEntity<ResponseDTO<AssignmentDTO>> update(@RequestBody AssignmentDTO assignmentDTO, BindingResult bindingResult) {
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(assignmentDTO.getId() == null) {
            responseDTO.setStatus("400");
            responseDTO.setMessage("ID is required");
        }
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = assignmentService.save(assignmentDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/api/admin/assignment")
    public void delete(@RequestBody Long[] ids) {
        assignmentService.delete(ids);
    }
}
