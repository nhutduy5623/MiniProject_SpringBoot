package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.DepartmentEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DepartmentSpecification extends BaseSpecification<DepartmentEntity> {
    public Specification<DepartmentEntity> hasName(String name) {
        return super.like("name", name);
    }
}
