package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.ProjectEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IProjectMapper;
import com.TSP.MiniProject_SpringBoot.repository.IDeptAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectConverter {
    @Autowired
    IProjectMapper projectMapper;

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IDeptAssignmentRepository deptAssignmentRepository;

    public ProjectDTO toDTO(ProjectEntity projectEntity) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO = projectMapper.toDTO(projectEntity);
        HashMap<String, String> deptsChargeMap = new HashMap<>();
        for(DeptAssignmentEntity deptCharge : projectEntity.getList_DeptAssignment()) {
            deptsChargeMap.put(deptCharge.getDept().getCode(), deptCharge.getDept().getName());
        }
        projectDTO.setDepts_charge(deptsChargeMap);
        return projectDTO;
    }

    public ProjectEntity toEntity(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity = projectMapper.toEntity(projectDTO);
        for (Map.Entry<String, String> entry : projectDTO.getDepts_charge().entrySet())
            projectEntity.getList_DeptAssignment().add(deptAssignmentRepository.findOneByCode(entry.getKey()));
        return projectEntity;
    }

    public List<ProjectDTO> toListDTOs(List<ProjectEntity> projectEntities) {
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (ProjectEntity projectEntity : projectEntities) {
            projectDTOS.add(this.toDTO(projectEntity));
        }
        return projectDTOS;
    }

    public List<ProjectEntity> toListEntity(List<ProjectDTO> projectDTOS) {
        List<ProjectEntity> projectEntities = new ArrayList<>();
        for (ProjectDTO projectDTO : projectDTOS) {
            projectEntities.add(this.toEntity(projectDTO));
        }
        return projectEntities;
    }
}
