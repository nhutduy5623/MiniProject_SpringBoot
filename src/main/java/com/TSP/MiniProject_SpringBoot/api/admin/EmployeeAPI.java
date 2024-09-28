package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ExcelDTO.EmployeeExcel;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class EmployeeAPI {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/api/admin/employee")
    public ResponseEntity<ResponseDTO<EmployeeDTO>> save(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = employeeService.save(employeeDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/api/admin/employee")
    public ResponseEntity<ResponseDTO<EmployeeDTO>> update(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) {
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>();
        responseDTO = responseDTO.validateResponse(bindingResult);
        if(employeeDTO.getId() == null) {
            responseDTO.setStatus("400");
            responseDTO.setMessage("ID is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        }
        if(responseDTO.getStatus() != "200")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
        responseDTO = employeeService.save(employeeDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/api/admin/employee")
    public void delete(@RequestBody Long[] ids) {
        employeeService.delete(ids);
    }

    @GetMapping("/api/admin/employee/excel_export")
    public ResponseDTO<EmployeeDTO> excel_export(@RequestParam(value = "search", required = false) String search,
                                                 @RequestParam(value = "dept_code", required = false) String dept_code) {
        EmployeeDTO employeeCondition = new EmployeeDTO();
        employeeCondition.setFull_name(search);
        employeeCondition.setDept_code(dept_code);
        PageRequest pageRequest = PageRequest.of(0, Integer.MAX_VALUE);
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.findBySpecification(employeeCondition, pageRequest);
        return responseDTO;
    }

}
