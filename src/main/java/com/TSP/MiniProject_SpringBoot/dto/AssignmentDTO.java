package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDTO extends AbstractDTO{
    private String name;
    private String detail;
    private Integer priority_lvl;
    private Integer status;
}
