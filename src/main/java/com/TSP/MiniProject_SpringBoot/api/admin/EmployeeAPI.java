package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeAPI {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/admin/employee")
    public ResponseDTO<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO) {
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.save(employeeDTO);
        return responseDTO;
    }

    @PutMapping("/admin/employee")
    public ResponseDTO<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.save(employeeDTO);
        return responseDTO;
    }

    @DeleteMapping("/admin/employee")
    public void delete(@RequestBody Long[] ids) {
        employeeService.delete(ids);
    }

}
