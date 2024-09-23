package com.TSP.MiniProject_SpringBoot.service.converter;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.mapper.IAccountMapper;
import com.TSP.MiniProject_SpringBoot.repository.IAccountRepository;
import com.TSP.MiniProject_SpringBoot.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountConverter {

    @Autowired
    IAccountMapper accountMapper;

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    public AccountDTO toDTO(AccountEntity accountEntity) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO = accountMapper.toDTO(accountEntity);
        if(accountEntity.getEmployee() != null) {
            accountDTO.setEmployee_code(accountEntity.getEmployee().getCode());
            accountDTO.setEmployee_name(accountEntity.getEmployee().getFull_name());
        }
        return accountDTO;
    }

    public AccountEntity toEntity(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity = accountMapper.toEntity(accountDTO);
        accountEntity.setEmployee(employeeRepository.findOneByCode(accountDTO.getEmployee_code()));
        return accountEntity;
    }

    public List<AccountDTO> toListDTOs(List<AccountEntity> accountEntities) {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (AccountEntity accountEntity : accountEntities) {
            accountDTOS.add(this.toDTO(accountEntity));
        }
        return accountDTOS;
    }

    public List<AccountEntity> toListEntity(List<AccountDTO> accountDTOS) {
        List<AccountEntity> accountEntities = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOS) {
            accountEntities.add(this.toEntity(accountDTO));
        }
        return accountEntities;
    }

}
