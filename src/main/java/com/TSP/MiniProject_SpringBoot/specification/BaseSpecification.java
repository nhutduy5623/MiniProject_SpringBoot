package com.TSP.MiniProject_SpringBoot.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.function.Function;

public class BaseSpecification<T> {
    public Specification<T> like(String key, String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get(key), "%" + value + "%");
        };
    }
    public Specification<T> like_WithOtherElement(Function<Root<T>, Path<String>> pathFunction, String value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null || value.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(pathFunction.apply(root), "%" + value + "%");
//            pathFunction.apply(root) là một tham số dùng chung. có thể là root.get(key), root.join("dept").get("id"),...
        };
    }
    public Specification<T> equal(Function<Root<T>, Path<?>> pathFunction, Object value) {
        return (root, query, criteriaBuilder) -> {
            if (value == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(pathFunction.apply(root), value);
//            pathFunction.apply(root) là một tham số dùng chung. có thể là root.get(key), root.join("dept").get("id"),...
        };
    }
    public Specification<T> statusEnabled() {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("status"), 1);
        };
    }
}
