package com.mzo.search.service;

import com.mzo.search.dto.PersonDto;
import com.mzo.search.model.PersonPage;

import java.util.List;
import java.util.Map;

public interface PersonService {

    List<PersonDto> findAllPersons();
    List<PersonDto> findWithPagination(Map<String, String> filters);
    List<PersonDto> findWithoutPagination(Map<String, String> filters);
    PersonPage findPagePerson(Map<String, String> filters);
}
