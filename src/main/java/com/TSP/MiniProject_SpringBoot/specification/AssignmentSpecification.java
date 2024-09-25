package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.AssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AssignmentSpecification extends BaseSpecification<AssignmentEntity> {

    public Specification<AssignmentEntity> hasProject(String projectCode) {
        Specification<AssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("deptAssignment").join("project").get("code"), projectCode));
    }
    public Specification<AssignmentEntity> hasProjectName(String projectName) {
        Specification<AssignmentEntity> spec = Specification.where(null);
        return spec.and(super.like_WithOtherElement(root->root.join("deptAssignment").join("project").get("name"), projectName));
    }
    public Specification<AssignmentEntity> hasDept(String deptCode) {
        Specification<AssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("deptAssignment").join("dept").get("code"), deptCode));
    }
    public Specification<AssignmentEntity> hasEmployee(String employeeCode) {
        Specification<AssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("responsible_person").get("code"), employeeCode));
    }
}
