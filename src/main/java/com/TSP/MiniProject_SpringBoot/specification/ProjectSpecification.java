package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import com.TSP.MiniProject_SpringBoot.entity.ProjectEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class ProjectSpecification extends BaseSpecification<ProjectEntity> {
    public Specification<ProjectEntity> hasName(String name) {
        return super.like("name", name);
    }
    public Specification<ProjectEntity> hasDepartmentCode(String deptCode) {
        Specification<ProjectEntity> spec = Specification.where(null);
        return spec.and(super.equal(root->root.join("list_projectDetail").join("deptEntity").get("code"), deptCode));
    }
}
