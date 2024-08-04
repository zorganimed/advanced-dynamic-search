package com.mzo.search.application.model;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;

public interface JPASearchFunction<T,V>{
    Expression<V> apply(CriteriaBuilder t, Expression<T>[] expressions, Object[] values);
}
