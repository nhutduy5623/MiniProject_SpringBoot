package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IEmployeeMapper;
import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import com.TSP.MiniProject_SpringBoot.service.converter.EmployeeConverter;
import com.TSP.MiniProject_SpringBoot.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeMapper employeeMapper;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    EmployeeSpecification employeeSpec;

    @Autowired
    EmployeeConverter employeeConverter;

    @Override
    public ResponseDTO<EmployeeDTO> save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeConverter.toEntity(employeeDTO);
        employeeEntity = employeeRepository.save(employeeEntity);
        employeeDTO = employeeConverter.toDTO(employeeEntity);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", employeeDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            EmployeeEntity deleteEntity = new EmployeeEntity();
            deleteEntity = employeeRepository.findById(id).get();
            deleteEntity.setStatus(0);
            employeeRepository.save(deleteEntity);
        }
    }

    @Override
    public ResponseDTO<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeConverter.toListDTOs(employeeEntities);
        EmployeeDTO result = new EmployeeDTO();
        result.setListResults(employeeDTOS);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }

    @Override
    public ResponseDTO<EmployeeDTO> findOne(Long id) {
        EmployeeEntity EmployeeEntity = employeeRepository.findById(id).get();
        EmployeeDTO EmployeeDTO = employeeConverter.toDTO(EmployeeEntity);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", EmployeeDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<EmployeeDTO> findOneByCode(String code) {
        EmployeeEntity employeeEntity = employeeRepository.findOneByCode(code);
        EmployeeDTO employeeDTO = employeeConverter.toDTO(employeeEntity);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", employeeDTO);

        return responseDTO;
    }

    @Override
    public ResponseDTO<EmployeeDTO> findBySpecification(EmployeeDTO employeeCondition, Pageable pageable) {
        Specification<EmployeeEntity> spec = Specification.where(null);
        if(employeeCondition.getFull_name() != null)
            spec = spec.and(employeeSpec.hasFullName(employeeCondition.getFull_name()));
        if(employeeCondition.getDept_code() != null)
            spec = spec.and(employeeSpec.hasDepartmentCode(employeeCondition.getDept_code()));
        spec = spec.and(employeeSpec.statusEnabled());
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll(spec, pageable).getContent();
        List<EmployeeDTO> employeeDTOs = employeeConverter.toListDTOs(employeeEntities);
        EmployeeDTO result = new EmployeeDTO();
        result.setListResults(employeeDTOs);
        Integer countData = Integer.parseInt(employeeRepository.count(spec)+"");
        result.setNextPage(pageable.getPageNumber()+1);
        result.setLimit(pageable.getPageSize());
        result.setTotalPages((int) Math.ceil((double) countData/result.getLimit()));
        if (result.getTotalPages() == 0 )
            result.setTotalPages(1);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }

}
