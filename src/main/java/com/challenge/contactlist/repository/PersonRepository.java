package com.challenge.contactlist.repository;

import com.challenge.contactlist.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<Person> findByName(String name, Pageable pageable);

    Person findByName(String name);

}
