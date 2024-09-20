package com.TSP.MiniProject_SpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectTeamDetailDTO extends AbstractDTO{
    private ProjectDTO project;
    private TeamDTO team;
    private Integer priority_level;
}
