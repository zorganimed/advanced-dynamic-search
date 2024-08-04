package com.mzo.search.application.model;

import com.mzo.search.application.exception.JPASearchException;
import com.mzo.search.application.function.JPASearchFunctions;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum JPASearchOperatorGroup {

    AND("and", JPASearchFunctions.AND),
    OR("or", JPASearchFunctions.OR),
    NOT("not", JPASearchFunctions.NOT);

    private final String value;
    private final JPASearchFunction<?, ?> function;

    public static JPASearchOperatorGroup load(String name) {
        return Stream.of(JPASearchOperatorGroup.values()).filter(f -> f.getValue().equals(name)).findAny()
                .orElseThrow(() -> new JPASearchException("Unknown operator: " + name));
    }
}
