package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IEmployeeMapper;
import com.TSP.MiniProject_SpringBoot.repository.IDepartmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeConverter {

    @Autowired
    IEmployeeMapper employeeMapper;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    IDepartmentRepository deptRepository;

    public EmployeeDTO toDTO(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO = employeeMapper.toDTO(employeeEntity);
        if(employeeEntity.getDept() != null)
            employeeDTO.setDept_code(employeeEntity.getDept().getCode());
        return employeeDTO;
    }

    public EmployeeEntity toEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity = employeeMapper.toEntity(employeeDTO);
        employeeEntity.setDept(deptRepository.findOneByCode(employeeDTO.getDept_code()));
        return employeeEntity;
    }

    public List<EmployeeDTO> toListDTOs(List<EmployeeEntity> employeeEntities) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            employeeDTOS.add(this.toDTO(employeeEntity));
        }
        return employeeDTOS;
    }

    public List<EmployeeEntity> toListEntity(List<EmployeeDTO> employeeDTOS) {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDTOS) {
            employeeEntities.add(this.toEntity(employeeDTO));
        }
        return employeeEntities;
    }
}
