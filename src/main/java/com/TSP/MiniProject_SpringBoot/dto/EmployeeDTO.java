package com.TSP.MiniProject_SpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDTO extends AbstractDTO{
    private String full_name;
    private Date dob;
    private String address;
    private String position;
    private Date start_day;
    private String dept_code;
    private Double basic_salary;
    private List<AccountDTO> accountDTOList = new ArrayList<>();
    private List<AssignmentDTO> assignmentDTOList = new ArrayList<>();
    private List<SalaryHistoryDTO> salaryHistoryDTOList = new ArrayList<>();
}
