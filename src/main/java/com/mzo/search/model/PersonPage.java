package com.mzo.search.model;

import com.mzo.search.dto.PersonDto;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PersonPage {

    private Map keyword;
    private int page;
    private int size;
    private int totalPages;
    private List<PersonDto> personDtos;
}
