package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProjectDTO extends AbstractDTO{
    private String name;
    private String detail;
    private Date start_day;
    private Date duration;
    private Integer status;
    private List<AssignmentDTO> assignmentDTOList = new ArrayList<>();
    private List<SalaryHistoryDTO> salaryHistoryDTOList = new ArrayList<>();
}
