package com.mzo.search.repository;

import com.mzo.search.application.repository.JPASearchRepository;
import com.mzo.search.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>, JPASearchRepository<Person> {
}
