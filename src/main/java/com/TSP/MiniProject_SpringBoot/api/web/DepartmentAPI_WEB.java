package com.TSP.MiniProject_SpringBoot.api.web;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentAPI_WEB {

    @Autowired
    IDepartmentService deptService;

    @GetMapping(value = "/api/dept")
    public ResponseDTO<DepartmentDTO> homePage(@RequestParam(value = "search", required = false) String search,
                                               @RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "limit", required = false) Integer limit) {
        if(search == "")
            search = null;
        if(page == null)
            page = 1;
        if(limit == null)
            limit = 5;
        PageRequest pageRequest = PageRequest.of(page-1, limit);
        DepartmentDTO deptCondition = new DepartmentDTO();
        deptCondition.setName(search);
        ResponseDTO<DepartmentDTO> responseDTO = deptService.findBySpecification(deptCondition, pageRequest);
        return responseDTO;
    }

    @GetMapping(value = "/api/dept/{code}")
    public ResponseDTO<DepartmentDTO> findByCode(@PathVariable String code) {
        ResponseDTO<DepartmentDTO> responseDTO = deptService.findOneByCode(code);
        return responseDTO;
    }

    @GetMapping(value = "/api/dept_id/{id}")
    public ResponseDTO<DepartmentDTO> findById(@PathVariable Long id) {
        ResponseDTO<DepartmentDTO> responseDTO = deptService.findOne(id);
        return responseDTO;
    }

}
