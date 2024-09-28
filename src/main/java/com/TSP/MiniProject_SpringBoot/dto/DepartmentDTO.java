package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class DepartmentDTO extends AbstractDTO{


    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "task_detail is required")
    private String task_detail;


    private String leader_code;
    private String leader_name;
    private HashMap<String, String> projects_charge = new HashMap<>();
    private List<EmployeeDTO> list_employee = new ArrayList<>();
}
