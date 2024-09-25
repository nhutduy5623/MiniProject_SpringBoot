package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IAssignmentMapper;
import com.TSP.MiniProject_SpringBoot.repository.*;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentConverter {
    
    @Autowired
    IAssignmentMapper assignmentMapper;

    @Autowired
    IAssignmentRepository assignmentRepository;

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IDeptAssignmentService deptAssignmentService;

    @Autowired
    IEmployeeRepository employeeRepository;

    public AssignmentDTO toDTO(AssignmentEntity assignmentEntity) {
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO = assignmentMapper.toDTO(assignmentEntity);
        if(assignmentEntity.getDeptAssignment() != null) {
            assignmentDTO.setProject_code(assignmentEntity.getDeptAssignment().getProject().getCode());
            assignmentDTO.setProject_name(assignmentEntity.getDeptAssignment().getProject().getName());
            assignmentDTO.setDept_code(assignmentEntity.getDeptAssignment().getDept().getCode());
        }
        if(assignmentEntity.getResponsible_person() != null)
            assignmentDTO.setResponsible_person_code(assignmentEntity.getResponsible_person().getCode());
        return assignmentDTO;
    }

    public AssignmentEntity toEntity(AssignmentDTO assignmentDTO) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity = assignmentMapper.toEntity(assignmentDTO);
        assignmentEntity.setDeptAssignment(deptAssignmentService.findOneByProjectAndDept(assignmentDTO.getProject_code(), assignmentDTO.getDept_code()));
        assignmentEntity.setResponsible_person(employeeRepository.findOneByCode(assignmentDTO.getResponsible_person_code()));
        return assignmentEntity;
    }

    public List<AssignmentDTO> toListDTOs(List<AssignmentEntity> assignmentEntities) {
        List<AssignmentDTO> assignmentDTOS = new ArrayList<>();
        for (AssignmentEntity assignmentEntity : assignmentEntities) {
            assignmentDTOS.add(this.toDTO(assignmentEntity));
        }
        return assignmentDTOS;
    }

    public List<AssignmentEntity> toListEntity(List<AssignmentDTO> assignmentDTOS) {
        List<AssignmentEntity> assignmentEntities = new ArrayList<>();
        for (AssignmentDTO assignmentDTO : assignmentDTOS) {
            assignmentEntities.add(this.toEntity(assignmentDTO));
        }
        return assignmentEntities;
    }
}
