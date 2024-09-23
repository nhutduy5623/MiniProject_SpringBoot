package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import org.springframework.data.jpa.domain.Specification;

public class DeptAssignmentSpecification extends BaseSpecification<DeptAssignmentEntity> {
    public Specification<DeptAssignmentEntity> hasDepartment(String deptCode) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("deptEntity").get("code"), deptCode));
    }
    public Specification<DeptAssignmentEntity> hasProject(String projectCode) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("projectEntity").get("code"), projectCode));
    }
}
