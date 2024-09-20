package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
public class ProjectEntity extends AbstractEntity {

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String detail;

    @Column
    private Date start_day;

    @Column
    private Date duration;

    @Column
    private Integer status;

    @OneToMany(mappedBy = "projectEntity", fetch = FetchType.LAZY)
    private List<AssignmentEntity> list_assignment = new ArrayList<>();

    @OneToMany(mappedBy = "projectEntity", fetch = FetchType.LAZY)
    private List<ProjectTeamDetailEntity> list_projectDetail = new ArrayList<>();

}
