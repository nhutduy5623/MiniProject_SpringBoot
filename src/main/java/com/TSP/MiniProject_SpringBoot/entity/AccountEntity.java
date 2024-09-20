package com.TSP.MiniProject_SpringBoot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
public class AccountEntity extends AbstractEntity {

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

}
