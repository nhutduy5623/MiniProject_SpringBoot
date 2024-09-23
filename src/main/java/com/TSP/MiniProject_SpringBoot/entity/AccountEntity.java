package com.TSP.MiniProject_SpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
public class AccountEntity extends AbstractEntity {

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties("list_account")
    private EmployeeEntity employee;

}
