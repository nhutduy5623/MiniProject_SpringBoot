package com.TSP.MiniProject_SpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeEntity extends AbstractEntity {

    @Column
    private String full_name;

    @Column
    private String avatar;

    @Column
    private Date dob;

    @Column
    private String address;

    @Column
    private String position;

    @Column
    private Date start_day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private DepartmentEntity dept;

    @Column
    private Double basic_salary;

    @Column
    private Integer status;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<AccountEntity> list_account = new ArrayList<>();

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY)
    private List<SalaryHistoryEntity> list_salary_history = new ArrayList<>();

    @OneToMany(mappedBy = "leader", fetch = FetchType.LAZY)
    private List<DepartmentEntity> department_leads;

    @OneToMany(mappedBy = "responsible_person", fetch = FetchType.LAZY)
    private List<AssignmentEntity> list_assignment = new ArrayList<>();

}
