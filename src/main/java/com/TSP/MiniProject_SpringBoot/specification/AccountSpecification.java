package com.TSP.MiniProject_SpringBoot.specification;

import com.TSP.MiniProject_SpringBoot.entity.AccountEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AccountSpecification extends BaseSpecification<AccountEntity> {
    public Specification<AccountEntity> hasEmployeeName(String name) {
        Specification<AccountEntity> spec = Specification.where(null);
        return spec.and(super.like_WithOtherElement(root->root.join("employee").get("full_name"), name));
    }
}
