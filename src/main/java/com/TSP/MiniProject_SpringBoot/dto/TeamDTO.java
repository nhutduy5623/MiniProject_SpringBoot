package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TeamDTO extends AbstractDTO{
    private String name;
    private String task_detail;
    private EmployeeDTO leader;
    private Integer status;
    private List<ProjectTeamDetailDTO> projectTeamDetailDTOList = new ArrayList<>();
    private List<EmployeeDTO> employeeDTOList = new ArrayList<>();
}
