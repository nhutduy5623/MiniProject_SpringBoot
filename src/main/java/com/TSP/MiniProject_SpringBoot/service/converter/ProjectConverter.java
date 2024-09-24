package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.ProjectEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IProjectMapper;
import com.TSP.MiniProject_SpringBoot.repository.IDepartmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IDeptAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IProjectRepository;
import com.TSP.MiniProject_SpringBoot.service.impl.DeptAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

    @Autowired
    DeptAssignmentService deptAssignmentService;

    @Autowired
    IDepartmentRepository departmentRepository;

    public ProjectDTO toDTO(ProjectEntity projectEntity) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO = projectMapper.toDTO(projectEntity);
        HashMap<String, String> deptsChargeMap = new HashMap<>();
        for(DeptAssignmentEntity deptCharge : projectEntity.getList_DeptAssignment()) {
            deptsChargeMap.put(deptCharge.getDept().getCode(), deptCharge.getMainTaskDetails());
        }
        projectDTO.setDepts_charge(deptsChargeMap);
        return projectDTO;
    }

    public ProjectEntity toEntity(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity = projectMapper.toEntity(projectDTO);
        for (Map.Entry<String, String> entry : projectDTO.getDepts_charge().entrySet()) {
            DeptAssignmentEntity deptAssignmentEntity = deptAssignmentService.findOneByProjectAndDept(projectDTO.getCode(), entry.getKey());
            if (deptAssignmentEntity == null) {
                deptAssignmentEntity = new DeptAssignmentEntity();
                deptAssignmentEntity.setDept(departmentRepository.findOneByCode(entry.getKey()));
                deptAssignmentEntity.setMainTaskDetails(entry.getValue());
                deptAssignmentEntity.setProject(projectEntity);
                projectEntity.getList_DeptAssignment().add(deptAssignmentEntity);
            } else {
                projectEntity.getList_DeptAssignment().add(deptAssignmentEntity);
            }
        }

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
