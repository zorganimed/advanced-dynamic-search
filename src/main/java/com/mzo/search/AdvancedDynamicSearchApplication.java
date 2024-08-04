package com.mzo.search;

import com.mzo.search.dto.PersonDto;
import com.mzo.search.entity.Person;
import com.mzo.search.mapper.PersonMapper;
import com.mzo.search.repository.PersonRepository;
import com.mzo.search.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AdvancedDynamicSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedDynamicSearchApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonMapper personMapper, PersonRepository personRepository){
        return args -> {
            for (int i = 0; i < 100; i++) {

                PersonDto personDto = new PersonDto();
                personDto.setFirstName("Mohamed"+i);
                personDto.setLastName("Zorgani"+i);
                personDto.setCountry("Tunisia"+i);
                personDto.setBirthDate(LocalDate.of(1990, 05, 20));
                Person person = personMapper.toPerson(personDto);
                personRepository.save(person);

                PersonDto personDto1 = new PersonDto();
                personDto1.setFirstName("Ahmed"+i);
                personDto1.setLastName("Ahmed"+i);
                personDto1.setCountry("German"+i);
                personDto1.setBirthDate(LocalDate.of(1995, 05, 20));
                Person person1 = personMapper.toPerson(personDto1);
                personRepository.save(person1);
            }

        };
    }
}
