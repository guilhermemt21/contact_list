package com.challenge.contactlist.controller.form;

import com.challenge.contactlist.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class PersonForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String name;

    @NotNull
    @NotEmpty
    private List<ContactForm> contacts;

    public Person convert() {
        return Person.builder()
                .name(this.getName())
                .contacts(this.contacts.stream().map(ContactForm::convert).collect(Collectors.toList()))
                .build();
    }


    public Person update(Person person) {
        return Person.builder()
                .id(person.getId())
                .name(this.getName())
                .contacts(this.contacts.stream().map(ContactForm::convert).collect(Collectors.toList()))
                .build();
    }
}

