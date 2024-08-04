package com.mzo.search.mapper;

import com.mzo.search.dto.PersonDto;
import com.mzo.search.entity.Person;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public Person toPerson(PersonDto personDto){
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        person.setDateOfBirth(personDto.getBirthDate());
        return  person;
    }

    public PersonDto fromPerson(Person person){
        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(person, personDto);
        personDto.setBirthDate(person.getDateOfBirth());
        return  personDto;
    }
}
