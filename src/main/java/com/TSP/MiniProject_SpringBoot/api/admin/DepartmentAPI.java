package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentAPI {

    @Autowired
    IDepartmentService departmentService;

    @PostMapping("/api/admin/dept")
    public ResponseEntity<ResponseDTO<DepartmentDTO>> save(@RequestBody DepartmentDTO deptDTO, BindingResult bindingResult) {
        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = departmentService.save(deptDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/api/admin/dept")
    public ResponseEntity<ResponseDTO<DepartmentDTO>> update(@RequestBody DepartmentDTO deptDTO, BindingResult bindingResult) {
        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(deptDTO.getId() == null) {
            responseDTO.setStatus("400");
            responseDTO.setMessage("ID is required");
        }
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = departmentService.save(deptDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/api/admin/dept")
    public void delete(@RequestBody Long[] ids) {
        departmentService.delete(ids);
    }

}
