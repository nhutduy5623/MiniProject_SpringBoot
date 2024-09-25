package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IDepartmentMapper;
import com.TSP.MiniProject_SpringBoot.repository.IDeptAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentConverter {

    @Autowired
    IDepartmentMapper DepartmentMapper;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    IDeptAssignmentRepository deptAssignmentRepository;

    public DepartmentDTO toDTO(DepartmentEntity departmentEntity) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO = DepartmentMapper.toDTO(departmentEntity);
        if(departmentEntity.getLeader() != null) {
            departmentDTO.setLeader_code(departmentEntity.getLeader().getCode());
            departmentDTO.setLeader_name(departmentEntity.getLeader().getFull_name());
        }
        HashMap<String, String> projects_ChargeMap = new HashMap<>();
        for(DeptAssignmentEntity projectCharge : departmentEntity.getList_DeptAssignment()) {
            projects_ChargeMap.put(projectCharge.getDept().getCode(), projectCharge.getMainTaskDetails() );
        }
        departmentDTO.setProjects_charge(projects_ChargeMap);
        return departmentDTO;
    }

    public DepartmentEntity toEntity(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity = DepartmentMapper.toEntity(departmentDTO);
        departmentEntity.setLeader(employeeRepository.findOneByCode(departmentDTO.getLeader_code()));
        for (Map.Entry<String, String> entry : departmentDTO.getProjects_charge() .entrySet())
            departmentEntity.getList_DeptAssignment().add(deptAssignmentRepository.findOneByCode(entry.getKey()));
        return departmentEntity;
    }

    public List<DepartmentDTO> toListDTOs(List<DepartmentEntity> DepartmentEntities) {
        List<DepartmentDTO> DepartmentDTOS = new ArrayList<>();
        for (DepartmentEntity DepartmentEntity : DepartmentEntities) {
            DepartmentDTOS.add(this.toDTO(DepartmentEntity));
        }
        return DepartmentDTOS;
    }

    public List<DepartmentEntity> toListEntities(List<DepartmentDTO> DepartmentDTOs) {
        List<DepartmentEntity> DepartmentEntities = new ArrayList<>();
        for (DepartmentDTO DepartmentDTO : DepartmentDTOs) {
            DepartmentEntities.add(this.toEntity(DepartmentDTO));
        }
        return DepartmentEntities;
    }

}
