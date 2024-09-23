package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class DepartmentDTO extends AbstractDTO{
    private String name;
    private String code;
    private String task_detail;
    private String leader_code;
    private String leader_name;
    private HashMap<String, String> projects_charge = new HashMap<>();
    private List<EmployeeDTO> list_employee = new ArrayList<>();
}
