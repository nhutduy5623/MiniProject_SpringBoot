package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SalaryHistoryDTO extends AbstractDTO{
    @NotBlank(message = "detail is required")
    private Long employee_Code;
    private Double basic_salary;
    private Double tax;
    private Double bonus_salary;
    private Double penalty;
    private String detail;
}
