package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryHistoryDTO extends AbstractDTO{
    private Long employee_id;
    private Double basic_salary;
    private Double tax;
    private Double bonus_salary;
    private Double penalty;
    private String detail;
    private Integer status;
}
