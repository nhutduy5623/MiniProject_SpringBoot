package com.TSP.MiniProject_SpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeptAssignmentDTO extends AbstractDTO{
    private ProjectDTO project;
    private DepartmentDTO dept;
    private String mainTaskDetails;
    private Integer priority_level;
    private List<AssignmentDTO> list_assignment = new ArrayList<>();
}
