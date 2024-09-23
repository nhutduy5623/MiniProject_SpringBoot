package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.DepartmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.repository.IDepartmentRepository;
import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import com.TSP.MiniProject_SpringBoot.service.IDepartmentService;
import com.TSP.MiniProject_SpringBoot.service.converter.DepartmentConverter;
import com.TSP.MiniProject_SpringBoot.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentConverter departmentConverter;

    @Autowired
    IDepartmentRepository departmentRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    DepartmentSpecification departmentSpec;

    @Override
    public ResponseDTO<DepartmentDTO> save(DepartmentDTO DepartmentDTO) {
        DepartmentEntity DepartmentEntity = departmentConverter.toEntity(DepartmentDTO);
        DepartmentEntity = departmentRepository.save(DepartmentEntity);
        DepartmentDTO = departmentConverter.toDTO(DepartmentEntity);
        EmployeeEntity leader = employeeRepository.findOneByCode(DepartmentDTO.getLeader_code());
        if (leader.getDept() == null || (leader.getCode()!="CEO" && leader.getDept().getCode() == "NoRole"))
            leader.setDept(DepartmentEntity);
        employeeRepository.save(leader);
        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>("Success", DepartmentDTO);
        return responseDTO;

    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
            EmployeeEntity leader = departmentEntity.getLeader();
            departmentEntity.setLeader(null);
            departmentEntity.setStatus(0);
            departmentRepository.save(departmentEntity);
            departmentRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDTO<DepartmentDTO> findAll() {
        List<DepartmentEntity> DepartmentEntities = new ArrayList<>();
        DepartmentEntities = departmentRepository.findAll();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setListResults(departmentConverter.toListDTOs(DepartmentEntities));
        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>("Success", departmentDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<DepartmentDTO> findOne(Long id) {
        DepartmentEntity DepartmentEntity = departmentRepository.findById(id).get();
        DepartmentDTO DepartmentDTO = departmentConverter.toDTO(DepartmentEntity);
        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>("Success", DepartmentDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<DepartmentDTO> findOneByCode(String code) {
        DepartmentEntity DepartmentEntity = departmentRepository.findOneByCode(code);
        DepartmentDTO DepartmentDTO = departmentConverter.toDTO(DepartmentEntity);
        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>("Success", DepartmentDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<DepartmentDTO> findBySpecification(DepartmentDTO departmentCondition, Pageable pageable) {
        Specification<DepartmentEntity> spec = Specification.where(null);
        if (departmentCondition.getName() != null)
            spec = spec.and(departmentSpec.hasName(departmentCondition.getName()));
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll(spec, pageable).getContent();
        DepartmentDTO result = new DepartmentDTO();
        result.setListResults(departmentConverter.toListDTOs(departmentEntities));

//      Total page
        Integer countData = Integer.parseInt(departmentRepository.count(spec)+"");
        result.setNextPage(pageable.getPageNumber()+1);
        result.setLimit(pageable.getPageSize());
        result.setTotalPages((int) Math.ceil((double) countData/result.getLimit()));
        if (result.getTotalPages() == 0 )
            result.setTotalPages(1);

        ResponseDTO<DepartmentDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }

}
