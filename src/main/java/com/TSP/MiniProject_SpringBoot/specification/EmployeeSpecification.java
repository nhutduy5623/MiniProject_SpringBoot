package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.EmployeeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification extends BaseSpecification<EmployeeEntity>{
    public Specification<EmployeeEntity> hasFullName(String name) {
        return super.like("full_name", name);
    }
    public Specification<EmployeeEntity> hasDepartmentCode(String deptCode) {
        Specification<EmployeeEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("dept").get("code"), deptCode));
    }
}
