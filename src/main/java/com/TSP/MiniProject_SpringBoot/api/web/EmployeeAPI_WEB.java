package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EmployeeAPI_WEB {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping(value = "/api/employee")
    public ResponseDTO<EmployeeDTO> homePage(@RequestParam(value = "search", required = false) String search,
                                             @RequestParam(value = "dept_code", required = false) String dept_code,
                                             @RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "limit", required = false) Integer limit) {
        if(search == "")
            search = null;
        if(page == null)
            page = 1;
        if(limit == null)
            limit = 5;
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        EmployeeDTO employeeCondition = new EmployeeDTO();
        employeeCondition.setFull_name(search);
        employeeCondition.setDept_code(dept_code);
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.findBySpecification(employeeCondition, pageRequest);
        return responseDTO;
    }

    @GetMapping(value = "/api/employee/{code}")
    public ResponseDTO<EmployeeDTO> findByCode(@PathVariable String code) {
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.findOneByCode(code);
        return responseDTO;
    }

    @GetMapping(value = "/api/employee_id/{id}")
    public ResponseDTO<EmployeeDTO> findById(@PathVariable Long id) {
        ResponseDTO<EmployeeDTO> responseDTO = employeeService.findOne(id);
        return responseDTO;
    }
}
