package com.TSP.MiniProject_SpringBoot.api.admin;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentAPI {

    @Autowired
    IDepartmentService deptService;

    @PostMapping("/api/admin/dept")
    public ResponseDTO<DepartmentDTO> save(@RequestBody DepartmentDTO deptDTO) {
        ResponseDTO<DepartmentDTO> responseDTO = deptService.save(deptDTO);
        return responseDTO;
    }

    @PutMapping("/api/admin/dept")
    public ResponseDTO<DepartmentDTO> update(@RequestBody DepartmentDTO deptDTO) {
        ResponseDTO<DepartmentDTO> responseDTO = deptService.save(deptDTO);
        return responseDTO;
    }

    @DeleteMapping("/api/admin/dept")
    public void delete(@RequestBody Long[] ids) {
        deptService.delete(ids);
    }

}
