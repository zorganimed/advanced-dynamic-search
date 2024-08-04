package com.mzo.search.application.model;

import com.mzo.search.application.annotation.Searchable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldDescriptor {

    private String path;
    private Searchable searchable;
    private JPASearchType searchType;
    private String entityKey;
}
