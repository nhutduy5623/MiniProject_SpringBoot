package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeEntity extends AbstractEntity {

    @Column
    private String full_name;

    @Column
    private Date dob;

    @Column
    private String address;

    @Column
    private String position;

    @Column
    private Date start_day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @Column
    private Double basic_salary;

    @Column
    private Integer status;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY)
    private List<AccountEntity> list_account = new ArrayList<>();

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY)
    private List<SalaryHistoryEntity> list_salary_history = new ArrayList<>();

    @OneToOne(mappedBy = "leader")
    private TeamEntity team_lead;

    @OneToMany(mappedBy = "responsible_person", fetch = FetchType.LAZY)
    private List<AssignmentEntity> list_assignment = new ArrayList<>();

}
