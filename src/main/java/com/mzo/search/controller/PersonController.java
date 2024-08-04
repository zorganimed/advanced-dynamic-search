package com.mzo.search.controller;

import com.mzo.search.dto.PersonDto;
import com.mzo.search.entity.Person;
import com.mzo.search.model.PersonPage;
import com.mzo.search.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersons(){
        return ResponseEntity.ok(personService.findAllPersons());
    }
/*http://localhost:8089/api/v1/persons/dynamicSearch?
firstName_endsWith=Ahmed
&lastName_in=Ahmed
&birthDate_lt=19980101
&_offset=0
&_limit=100
&birthDate_sort=ASC*/
    @GetMapping(path="/dynamicSearch", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findWithPagination(@RequestParam Map<String, String> requestParams) {
        return personService.findWithPagination(requestParams);
    }

    @GetMapping(path="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDto> findWithoutPagination(@RequestParam Map<String, String> requestParams) {
        return personService.findWithoutPagination(requestParams);
    }

    @GetMapping(path="/pagePerson", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonPage> findPagePerson(@RequestParam Map<String, String> requestParams) {
        return ResponseEntity.ok(personService.findPagePerson(requestParams));
    }

}
