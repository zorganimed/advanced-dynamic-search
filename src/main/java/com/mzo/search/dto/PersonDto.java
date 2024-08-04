package com.mzo.search.dto;

import com.mzo.search.application.annotation.Searchable;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PersonDto {

    @Searchable
    private String firstName;
    @Searchable
    private String lastName;
    @Searchable(entityFieldKey = "dateOfBirth")
    private LocalDate birthDate;
    @Searchable
    private String country;
}
