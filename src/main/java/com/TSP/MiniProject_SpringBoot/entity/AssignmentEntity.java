package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "assignment")
@Getter
@Setter
public class AssignmentEntity extends AbstractEntity {

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String detail;

    @Column
    private Integer priority_lvl;

    @Column
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptAssignment_id")
    private DeptAssignmentEntity deptAssignment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_person_id")
    private EmployeeEntity responsible_person;

}
