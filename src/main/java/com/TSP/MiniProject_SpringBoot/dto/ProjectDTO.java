package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ProjectDTO extends AbstractDTO{
    private String name;
    private String detail;
    private Date start_day;
    private Date duration;
    private List<AssignmentDTO> list_assignment = new ArrayList<>();
    private HashMap<String, String> depts_charge = new HashMap<>();
}
