package com.TSP.MiniProject_SpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AssignmentDTO extends AbstractDTO{

    @NotBlank(message = "name is required")
    private String name;
    private String detail;
    private Integer priority_lvl;

    private String project_code;
    private String project_name;

    @NotBlank(message = "dept_code is required")
    private String dept_code;


    @NotBlank(message = "responsible_person_code is required")
    private String responsible_person_code;
}
