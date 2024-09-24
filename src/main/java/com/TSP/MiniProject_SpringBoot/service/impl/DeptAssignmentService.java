package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.DeptAssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.repository.IDeptAssignmentRepository;
import com.TSP.MiniProject_SpringBoot.service.IDeptAssignmentService;
import com.TSP.MiniProject_SpringBoot.service.converter.DeptAssignmentConverter;
import com.TSP.MiniProject_SpringBoot.specification.DeptAssignmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptAssignmentService implements IDeptAssignmentService {

    @Autowired
    DeptAssignmentSpecification deptAssignmentSpec;

    @Autowired
    IDeptAssignmentRepository deptAssignmentRepository;

    @Autowired
    DeptAssignmentConverter deptAssignmentConverter;

    @Override
    public ResponseDTO<DeptAssignmentDTO> save(DeptAssignmentDTO deptAssignmentDTO) {
        ResponseDTO<DeptAssignmentDTO> responseDTO = new ResponseDTO<>();
        if (deptAssignmentDTO.getProject() == null || deptAssignmentDTO.getDept() == null) {
            responseDTO.setStatus("Error");
            responseDTO.setMessage("Missing data");
            return responseDTO;
        }
        DeptAssignmentEntity deptAssignmentEntity = deptAssignmentConverter.toEntity(deptAssignmentDTO);
        deptAssignmentEntity = deptAssignmentRepository.save(deptAssignmentEntity);
        deptAssignmentDTO = deptAssignmentConverter.toDTO(deptAssignmentEntity);
        responseDTO = new ResponseDTO<>("Success", deptAssignmentDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findAll() {
        return null;
    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findOne(Long id) {
        return null;
    }

    @Override
    public ResponseDTO<DeptAssignmentDTO> findOneByCode(String code) {
        return null;
    }



    @Override
    public ResponseDTO<DeptAssignmentDTO> findBySpecification(DeptAssignmentDTO deptAssignmentCondition, Pageable pageable) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        if (deptAssignmentCondition.getProject().getName() != null)
            spec = spec.and(deptAssignmentSpec.hasProjectName(deptAssignmentCondition.getProject().getName()));
        if (deptAssignmentCondition.getProject().getCode() != null)
            spec = spec.and(deptAssignmentSpec.hasProject(deptAssignmentCondition.getProject().getCode()));
        if (deptAssignmentCondition.getProject().getCode() != null)
            spec = spec.and(deptAssignmentSpec.hasDepartment(deptAssignmentCondition.getDept().getCode()));
        List<DeptAssignmentEntity> departmentEntities = deptAssignmentRepository.findAll(spec, pageable).getContent();
        DeptAssignmentDTO result = new DeptAssignmentDTO();
        result.setListResults(deptAssignmentConverter.toListDTOs(departmentEntities));

//      Total page
        Integer countData = Integer.parseInt(deptAssignmentRepository.count(spec)+"");
        result.setNextPage(pageable.getPageNumber()+1);
        result.setLimit(pageable.getPageSize());
        result.setTotalPages((int) Math.ceil((double) countData/result.getLimit()));
        if (result.getTotalPages() == 0 )
            result.setTotalPages(1);

        ResponseDTO<DeptAssignmentDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }

    @Override
    public DeptAssignmentEntity findOneByProjectAndDept(String projectCode, String deptCode) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        spec = spec.and(deptAssignmentSpec.hasProject(projectCode));
        spec = spec.and(deptAssignmentSpec.hasDepartment(deptCode));
        List<DeptAssignmentEntity> departmentEntities = deptAssignmentRepository.findAll(spec);
        DeptAssignmentEntity result = new DeptAssignmentEntity();
        if (departmentEntities.size() > 0)
            result = departmentEntities.get(0);
        else
            result = null;
        return result;
    }


}
