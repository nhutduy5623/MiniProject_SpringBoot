package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import com.TSP.MiniProject_SpringBoot.entity.DeptAssignmentEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DeptAssignmentSpecification extends BaseSpecification<DeptAssignmentEntity> {
    public Specification<DeptAssignmentEntity> hasDepartment(String deptCode) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("dept").get("code"), deptCode));
    }
    public Specification<DeptAssignmentEntity> hasProject(String projectCode) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("project").get("code"), projectCode));
    }
    public Specification<DeptAssignmentEntity> hasProjectName(String projectName) {
        Specification<DeptAssignmentEntity> spec = Specification.where(null);
        return spec.and(super.like_WithOtherElement(root->root.join("project").get("name"), projectName));
    }
}
