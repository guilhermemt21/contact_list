package com.challenge.contactlist.controller.dto;

import com.challenge.contactlist.model.Person;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PersonDTO {
    private Long id;
    private String name;
    private List<ContactDTO> contacts = new ArrayList<>();

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.contacts.addAll(person.getContacts().stream().map(ContactDTO::new).collect(Collectors.toList()));
    }

    public static Page<PersonDTO> convert(Page<Person> people) {
        return people.map(PersonDTO::new);
    }
}
