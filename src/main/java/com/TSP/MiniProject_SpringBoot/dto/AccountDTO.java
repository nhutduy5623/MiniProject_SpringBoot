package com.TSP.MiniProject_SpringBoot.dto;

import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO extends AbstractDTO{
    private String email;
    private String password;
    private String role;
    private String employee_code;
    private String employee_name;
}