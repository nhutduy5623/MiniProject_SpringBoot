package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
public class DepartmentEntity extends AbstractEntity{

    @Column
    private String name;

    @Column
    private String task_detail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leader_id", referencedColumnName = "id")
    private EmployeeEntity leader;

    @Column
    private Integer status;

    @OneToMany(mappedBy = "dept", fetch = FetchType.LAZY)
    private List<EmployeeEntity> list_employee = new ArrayList<>();

    @OneToMany(mappedBy = "dept", fetch = FetchType.LAZY)
    private List<DeptAssignmentEntity> list_DeptAssignment = new ArrayList<>();

}
