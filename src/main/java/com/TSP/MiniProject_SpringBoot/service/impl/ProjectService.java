package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ProjectDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.ProjectEntity;
import com.TSP.MiniProject_SpringBoot.entity.ProjectEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IProjectMapper;
import com.TSP.MiniProject_SpringBoot.repository.IProjectRepository;
import com.TSP.MiniProject_SpringBoot.service.IProjectService;
import com.TSP.MiniProject_SpringBoot.service.converter.ProjectConverter;
import com.TSP.MiniProject_SpringBoot.specification.ProjectSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    ProjectConverter projectConverter;

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    ProjectSpecification projectSpec;

    @Override
    public ResponseDTO<ProjectDTO> save(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = projectConverter.toEntity(projectDTO);
        projectEntity = projectRepository.save(projectEntity);
        projectDTO = projectConverter.toDTO(projectEntity);
        ResponseDTO<ProjectDTO> responseDTO = new ResponseDTO<>("Success", projectDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            projectRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDTO<ProjectDTO> findAll() {
        List<ProjectEntity> projectEntities = new ArrayList<>();
        projectEntities = projectRepository.findAll();
        List<ProjectDTO> projectDTOS = projectConverter.toListDTOs(projectEntities);
        ResponseDTO<ProjectDTO> responseDTO = new ResponseDTO<>("Success", projectDTOS);
        return responseDTO;
    }

    @Override
    public ResponseDTO<ProjectDTO> findOne(Long id) {
        ProjectEntity projectEntity = projectRepository.findById(id).get();
        ProjectDTO projectDTO = projectConverter.toDTO(projectEntity);
        ResponseDTO<ProjectDTO> responseDTO = new ResponseDTO<>("Success", projectDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<ProjectDTO> findOneByCode(String code) {
        ProjectEntity projectEntity = projectRepository.findOneByCode(code);
        ProjectDTO projectDTO = projectConverter.toDTO(projectEntity);
        ResponseDTO<ProjectDTO> responseDTO = new ResponseDTO<>("Success", projectDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<ProjectDTO> findBySpecification(ProjectDTO projectCondition, Pageable pageable) {
        Specification<ProjectEntity> spec = Specification.where(null);
        if (projectCondition.getName() != null)
            spec = spec.and(projectSpec.hasName(projectCondition.getName()));
        List<ProjectEntity> projectEntities = projectRepository.findAll(spec, pageable).getContent();
        ProjectDTO result = new ProjectDTO();
        result.setListResults(projectConverter.toListDTOs(projectEntities));

//      Total page
        Integer countData = Integer.parseInt(projectRepository.count(spec)+"");
        result.setNextPage(pageable.getPageNumber()+1);
        result.setLimit(pageable.getPageSize());
        result.setTotalPages((int) Math.ceil((double) countData/result.getLimit()));
        if (result.getTotalPages() == 0 )
            result.setTotalPages(1);
        ResponseDTO<ProjectDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }


}
