package com.TSP.MiniProject_SpringBoot.service.impl;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.dto.ResponseDTO;
import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IAccountMapper;
import com.TSP.MiniProject_SpringBoot.repository.IAccountRepository;
import com.TSP.MiniProject_SpringBoot.service.IAccountService;
import com.TSP.MiniProject_SpringBoot.service.converter.AccountConverter;
import com.TSP.MiniProject_SpringBoot.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountConverter accountConverter;

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    AccountSpecification accountSpec;

    @Override
    public ResponseDTO<AccountDTO> save(AccountDTO accountDTO) {
        AccountEntity accountEntity = accountConverter.toEntity(accountDTO);
        accountEntity = accountRepository.save(accountEntity);
        accountDTO = accountConverter.toDTO(accountEntity);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>("Success", accountDTO);
        return responseDTO;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            accountRepository.deleteById(id);
        }
    }

    @Override
    public ResponseDTO<AccountDTO> findAll() {
        List<AccountEntity> accountEntities = new ArrayList<>();
        accountEntities = accountRepository.findAll();
        List<AccountDTO> accountDTOS = accountConverter.toListDTOs(accountEntities);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>("Success", accountDTOS);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AccountDTO> findOne(Long id) {
        AccountEntity accountEntity = accountRepository.findById(id).get();
        AccountDTO accountDTO = accountConverter.toDTO(accountEntity);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>("Success", accountDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AccountDTO> findOneByCode(String code) {
        AccountEntity accountEntity = accountRepository.findOneByCode(code);
        AccountDTO accountDTO = accountConverter.toDTO(accountEntity);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>("Success", accountDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AccountDTO> findOneByEmail(String email) {
        AccountEntity accountEntity = accountRepository.findOneByEmail(email);
        AccountDTO accountDTO = accountConverter.toDTO(accountEntity);
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>("Success", accountDTO);
        return responseDTO;
    }

    @Override
    public ResponseDTO<AccountDTO> findBySpecification(AccountDTO accountCondition, Pageable pageable) {
        Specification<AccountEntity> spec = Specification.where(null);
        if (accountCondition.getEmployee_name() != null)
            spec = spec.and(accountSpec.hasEmployeeName(accountCondition.getEmployee_name()));
        List<AccountEntity> accountEntities = accountRepository.findAll(spec, pageable).getContent();
        AccountDTO result = new AccountDTO();
        result.setListResults(accountConverter.toListDTOs(accountEntities));

//      Total page
        Integer countData = Integer.parseInt(accountRepository.count(spec)+"");
        result.setNextPage(pageable.getPageNumber()+1);
        result.setLimit(pageable.getPageSize());
        result.setTotalPages((int) Math.ceil((double) countData/result.getLimit()));
        if (result.getTotalPages() == 0 )
            result.setTotalPages(1);

        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>("Success", result);
        return responseDTO;
    }
}
