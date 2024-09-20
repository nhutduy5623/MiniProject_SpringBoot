package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAPI_WEB {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping(value = "/employee")
    public ResponseDTO<EmployeeDTO> homePage() {
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.findAll();

        return responseDTO;
    }

    @GetMapping(value = "/employee/{code}")
    public ResponseDTO<EmployeeDTO> findByCode(@PathVariable String code) {
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.findOneByCode(code);
        return responseDTO;
    }
}
