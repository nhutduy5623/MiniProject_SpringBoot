package com.TSP.MiniProject_SpringBoot.dto.ExcelDTO;

import com.TSP.MiniProject_SpringBoot.dto.AccountDTO;
import com.TSP.MiniProject_SpringBoot.dto.AssignmentDTO;
import com.TSP.MiniProject_SpringBoot.dto.SalaryHistoryDTO;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeExcel {
    private String id;
    private String code;
    private String full_name;
    private Date dob;
    private String address;
    private String position;
    private Date start_day;
    private String dept_code;
    private Double basic_salary;
    private String createdBy;
    private java.util.Date createdDate;
    private String modifyBy;
    private java.util.Date modifyDate;
}
