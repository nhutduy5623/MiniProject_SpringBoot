package com.TSP.MiniProject_SpringBoot.dto;

import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AccountDTO extends AbstractDTO{
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 10, max = 30, message = "Email must be between 10 and 30 characters")
    private String password;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Code is required")
    private String employee_code;

    private String employee_name;
}