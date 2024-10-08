package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Team Assignment
@Entity
@Table(name = "project_Dept_detail")
@Getter
@Setter
public class DeptAssignmentEntity extends AbstractEntity { //Assign work to the team

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private DepartmentEntity dept;

    @OneToMany(mappedBy = "deptAssignment", fetch = FetchType.LAZY)
    private List<AssignmentEntity> list_assignment = new ArrayList<>();

    @Column
    private String mainTaskDetails;

    @Column
    private Integer priority_level;

}
