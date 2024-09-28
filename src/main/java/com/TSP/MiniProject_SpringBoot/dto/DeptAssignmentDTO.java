package com.TSP.MiniProject_SpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeptAssignmentDTO extends AbstractDTO{



    private ProjectDTO project;


    private DepartmentDTO dept;

    @NotBlank(message = "mainTaskDetails is required")
    private String mainTaskDetails;
    private Integer priority_level;
    private List<AssignmentDTO> list_assignment = new ArrayList<>();
}
