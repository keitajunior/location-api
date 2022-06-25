package com.ekom.locationapp.specifications;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.time.OffsetDateTime;

class GenericSpecification<T> {

    private final Class<T> type;

    public GenericSpecification(Class<T> type) {
        this.type = type;
    }

    public Specification<T> havingName(String field, String value) {
        return (root, query, builder) -> {
            Subquery<T> subquery = query.subquery(type);
            Root<T> subqueryRoot = subquery.from(type);
            Predicate namePredicate = builder.equal(subqueryRoot.get(field), value);
            subquery.select(subqueryRoot).where(namePredicate);
            return builder.exists(subquery);
        };
    }

    public Specification<T> withLike(String field, String value) {
        return (root, query, builder) -> builder.like(builder.lower(root.get(field)), value.toLowerCase().concat("%"));
    }

}
