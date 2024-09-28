package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.HashMap;

@Getter
@Setter
public class ProjectDTO extends AbstractDTO{

    @NotBlank(message = "name is required")
    private String name;

    private String detail;

    private Date start_day;
    private Date duration;
    private HashMap<String, String> depts_charge = new HashMap<>();
}
