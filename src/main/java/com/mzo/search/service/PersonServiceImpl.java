package com.mzo.search.service;

import com.mzo.search.dto.PersonDto;
import com.mzo.search.entity.Person;
import com.mzo.search.mapper.PersonMapper;
import com.mzo.search.model.PersonPage;
import com.mzo.search.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<PersonDto> findAllPersons() {
        List<Person> persons = personRepository.findAll();
        List<PersonDto> personDtos = persons.stream().map(p->personMapper.fromPerson(p)).toList();
        return personDtos;
    }

    /**
     *
     * with pagination
     */
    //Map<String, String> filters = new HashMap<>();
    @Override
    public List<PersonDto> findWithPagination(Map<String, String> filters) {
        //filters.put("firstName_eq", "Mohamed");
        //filters.put("lastName_startsWith", "Zor");
        //filters.put("birthDate_gte", "19910101");
        //filters.put("country_in", "IT,FR,DE");
       // filters.put("company.name_in", "Microsoft,Apple");
       // filters.put("company.employees_between", "500,5000");
        //filters.put("birthDate_sort" , "ASC");
        //filters.put("_limit", "10");
        //filters.put("_offset", "0");
       return personRepository.findAllWithPaginationAndSorting(filters, PersonDto.class)
                .map(p->personMapper.fromPerson(p)).stream().toList();
    }

    /**
     *
     * without pagination
     */
    @Override
    public List<PersonDto> findWithoutPagination(Map<String, String> filters) {
        //filters.put("firstName_eq", "Mohamed");
        //filters.put("lastName_startsWith", "Zor");
        //filters.put("birthDate_gte", "19910101");
        //filters.put("country_in", "IT,FR,DE");
        // filters.put("company.name_in", "Microsoft,Apple");
        // filters.put("company.employees_between", "500,5000");
        return personRepository.findAll(filters, PersonDto.class).stream().map(p->personMapper.fromPerson(p)).toList();
    }

    @Override
    public PersonPage findPagePerson(Map<String, String> filters) {
        Page<Person> persons = personRepository.findAllWithPaginationAndSorting(filters, PersonDto.class);
        PersonPage personPage = new PersonPage();
        if (filters.containsKey("_offset"))
        personPage.setPage(Integer.parseInt(filters.get("_offset").toString()));
        if (filters.containsKey("_limit"))
            personPage.setSize(Integer.parseInt(filters.get("_limit").toString()));
        personPage.setKeyword(filters);
        personPage.setTotalPages(persons.getTotalPages());
        personPage.setPersonDtos(persons.getContent().stream().map(p->personMapper.fromPerson(p)).toList());

        return personPage;
    }

    /**
     Map<String, JoinFetch> fetches = Map.of("companyEntity", JoinFetch.LEFT);
     personRepository.findAll(filters, Person.class, fetches);
     **/

}
