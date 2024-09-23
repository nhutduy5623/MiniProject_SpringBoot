package com.TSP.MiniProject_SpringBoot.mapper;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.EmployeeDTO;
import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAccountMapper {
    AccountDTO toDTO(AccountEntity accountEntity);
    AccountEntity toEntity(AccountDTO accountDTO);
    List<AccountDTO> toListDTOs(List<AccountEntity> entities);
    List<AccountEntity> toListEntities(List<AccountDTO> dtos);
}
