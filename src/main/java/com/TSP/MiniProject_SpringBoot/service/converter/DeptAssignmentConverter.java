package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IDeptAssignmentMapper;
import com.TSP.MiniProject_SpringBoot.repository.IDepartmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IDeptAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptAssignmentConverter {
    @Autowired
    IDeptAssignmentMapper deptAssignmentMapper;

    @Autowired
    IDeptAssignmentRepository deptAssignmentRepository;

    @Autowired
    IDepartmentRepository deptRepository;

    @Autowired
    IProjectRepository projectRepository;

    public DeptAssignmentDTO toDTO(DeptAssignmentEntity deptAssignmentEntity) {
        DeptAssignmentDTO deptAssignmentDTO = new DeptAssignmentDTO();
        deptAssignmentDTO = deptAssignmentMapper.toDTO(deptAssignmentEntity);
        return deptAssignmentDTO;
    }

    public DeptAssignmentEntity toEntity(DeptAssignmentDTO deptAssignmentDTO) {
        DeptAssignmentEntity deptAssignmentEntity = new DeptAssignmentEntity();
        deptAssignmentEntity = deptAssignmentMapper.toEntity(deptAssignmentDTO);
        deptAssignmentEntity.setDept(deptRepository.findOneByCode(deptAssignmentDTO.getDept().getCode()));
        deptAssignmentEntity.setProject(projectRepository.findOneByCode(deptAssignmentDTO.getProject().getCode()));
        return deptAssignmentEntity;
    }

    public List<DeptAssignmentDTO> toListDTOs(List<DeptAssignmentEntity> deptAssignmentEntities) {
        List<DeptAssignmentDTO> deptAssignmentDTOS = new ArrayList<>();
        for (DeptAssignmentEntity deptAssignmentEntity : deptAssignmentEntities) {
            deptAssignmentDTOS.add(this.toDTO(deptAssignmentEntity));
        }
        return deptAssignmentDTOS;
    }

    public List<DeptAssignmentEntity> toListEntity(List<DeptAssignmentDTO> deptAssignmentDTOS) {
        List<DeptAssignmentEntity> deptAssignmentEntities = new ArrayList<>();
        for (DeptAssignmentDTO deptAssignmentDTO : deptAssignmentDTOS) {
            deptAssignmentEntities.add(this.toEntity(deptAssignmentDTO));
        }
        return deptAssignmentEntities;
    }
}
