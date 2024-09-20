package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "salary_history")
@Getter
@Setter
public class SalaryHistoryEntity extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @Column
    private Double basic_salary;

    @Column
    private Double tax;

    @Column
    private Double bonus_salary;

    @Column
    private Double penalty;

    @Column(columnDefinition = "TEXT")
    private String detail;

    @Column
    private Integer status;
}
