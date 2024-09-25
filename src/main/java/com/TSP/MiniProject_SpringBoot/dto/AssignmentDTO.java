package com.TSP.MiniProject_SpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDTO extends AbstractDTO{
    private String name;
    private String detail;
    private Integer priority_lvl;
    private String project_code;
    private String project_name;
    private String dept_code;
    private String responsible_person_code;
}
