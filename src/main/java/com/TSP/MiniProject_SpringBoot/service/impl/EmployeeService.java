package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IEmployeeMapper;
import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import com.TSP.MiniProject_SpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeMapper employeeMapper;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public ResponseDTO<EmployeeDTO> save(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeMapper.toEntity(employeeDTO);
        employeeEntity = employeeRepository.save(employeeEntity);
        employeeDTO = employeeMapper.toDTO(employeeEntity);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", employeeDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            employeeRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDTO<EmployeeDTO> findAll() {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeMapper.toListDTOs(employeeEntities);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", employeeDTOS);
        return responseDTO;
    }

    @Override
    public ResponseDTO<EmployeeDTO> findOne(Long id) {
        EmployeeEntity EmployeeEntity = employeeRepository.findById(id).get();
        EmployeeDTO EmployeeDTO = employeeMapper.toDTO(EmployeeEntity);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", EmployeeDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<EmployeeDTO> findOneByCode(String code) {
        EmployeeEntity employeeEntity = employeeRepository.findOneByCode(code);
        EmployeeDTO employeeDTO = employeeMapper.toDTO(employeeEntity);
        ResponseDTO<EmployeeDTO> responseDTO = new ResponseDTO<>("Success", employeeDTO);
        return responseDTO;
    }
}
