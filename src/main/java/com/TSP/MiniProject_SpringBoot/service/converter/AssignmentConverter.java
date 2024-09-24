package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IAssignmentMapper;
import com.TSP.MiniProject_SpringBoot.repository.IDepartmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AssignmentConverter {
    
    @Autowired
    IAssignmentMapper assignmentMapper;

    @Autowired
    IAssignmentRepository assignmentRepository;

    @Autowired
    IProjectRepository projectRepository;

    public AssignmentDTO toDTO(AssignmentEntity assignmentEntity) {
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO = assignmentMapper.toDTO(assignmentEntity);
        if(assignmentEntity.getProject() != null)
            assignmentDTO.setProject_code(assignmentEntity.getProject().getCode());
        return assignmentDTO;
    }

    public AssignmentEntity toEntity(AssignmentDTO assignmentDTO) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity = assignmentMapper.toEntity(assignmentDTO);
        assignmentEntity.setProject(projectRepository.findOneByCode(assignmentDTO.getProject_code()));
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
