package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.*;
import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.repository.IAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.service.IAssignmentService;
import com.TSP.MiniProject_SpringBoot.service.converter.AssignmentConverter;
import com.TSP.MiniProject_SpringBoot.specification.AssignmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService implements IAssignmentService {

    @Autowired
    IAssignmentRepository assignmentRepository;

    @Autowired
    AssignmentSpecification assignmentSpec;

    @Autowired
    AssignmentConverter assignmentConverter;

    @Override
    public ResponseDTO<AssignmentDTO> save(AssignmentDTO assignmentDTO) {
        AssignmentEntity assignmentEntity = assignmentConverter.toEntity(assignmentDTO);
        assignmentEntity = assignmentRepository.save(assignmentEntity);
        assignmentDTO = assignmentConverter.toDTO(assignmentEntity);
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>("Success", assignmentDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            assignmentRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDTO<AssignmentDTO> findAll() {
        return null;
    }

    @Override
    public ResponseDTO<AssignmentDTO> findOne(Long id) {
        AssignmentEntity AssignmentEntity = assignmentRepository.findById(id).get();
        AssignmentDTO AssignmentDTO = assignmentConverter.toDTO(AssignmentEntity);
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>("Success", AssignmentDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AssignmentDTO> findOneByCode(String code) {
        AssignmentEntity AssignmentEntity = assignmentRepository.findOneByCode(code);
        AssignmentDTO AssignmentDTO = assignmentConverter.toDTO(AssignmentEntity);
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>("Success", AssignmentDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AssignmentDTO> findBySpecification(AssignmentDTO assignmentCondition, Pageable pageable) {
        Specification<AssignmentEntity> spec = Specification.where(null);
        if(assignmentCondition.getProject_name() != null)
            spec = spec.and(assignmentSpec.hasProjectName(assignmentCondition.getProject_name()));
        if(assignmentCondition.getProject_code() != null)
            spec = spec.and(assignmentSpec.hasProjectName(assignmentCondition.getProject_code()));
        if(assignmentCondition.getDept_code() != null)
            spec = spec.and(assignmentSpec.hasDept(assignmentCondition.getDept_code()));
        if(assignmentCondition.getResponsible_person_code() != null)
            spec = spec.and(assignmentSpec.hasEmployee(assignmentCondition.getResponsible_person_code()));
        spec = spec.and(assignmentSpec.statusEnabled());
        List<AssignmentEntity> assignmentEntities = assignmentRepository.findAll(spec, pageable).getContent();
        List<AssignmentDTO> assignmentDTOs = assignmentConverter.toListDTOs(assignmentEntities);
        AssignmentDTO result = new AssignmentDTO();
        result.setListResults(assignmentDTOs);
        Integer countData = Integer.parseInt(assignmentRepository.count(spec)+"");
        result.setNextPage(pageable.getPageNumber()+1);
        result.setLimit(pageable.getPageSize());
        result.setTotalPages((int) Math.ceil((double) countData/result.getLimit()));
        if (result.getTotalPages() == 0 )
            result.setTotalPages(1);
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AssignmentDTO> findBySpecification(AssignmentDTO assignmentCondition) {
        Specification<AssignmentEntity> spec = Specification.where(null);
        if(assignmentCondition.getProject_name() != null)
            spec = spec.and(assignmentSpec.hasProjectName(assignmentCondition.getProject_name()));
        if(assignmentCondition.getProject_code() != null)
            spec = spec.and(assignmentSpec.hasProjectName(assignmentCondition.getProject_code()));
        if(assignmentCondition.getDept_code() != null)
            spec = spec.and(assignmentSpec.hasDept(assignmentCondition.getDept_code()));
        if(assignmentCondition.getResponsible_person_code() != null)
            spec = spec.and(assignmentSpec.hasEmployee(assignmentCondition.getResponsible_person_code()));
        spec = spec.and(assignmentSpec.statusEnabled());
        List<AssignmentEntity> assignmentEntities = assignmentRepository.findAll(spec);
        List<AssignmentDTO> assignmentDTOs = assignmentConverter.toListDTOs(assignmentEntities);
        AssignmentDTO result = new AssignmentDTO();
        result.setListResults(assignmentDTOs);
        ResponseDTO<AssignmentDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }
}
