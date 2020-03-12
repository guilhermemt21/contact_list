package com.challenge.contactlist.controller;

import com.challenge.contactlist.controller.dto.PersonDTO;
import com.challenge.contactlist.controller.form.PersonForm;
import com.challenge.contactlist.model.Person;
import com.challenge.contactlist.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Page<PersonDTO> list(@RequestParam(required = false) String name,
                                @PageableDefault(sort = "name", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable) {

        if (name == null) {
            Page<Person> people = personRepository.findAll(pageable);
            return PersonDTO.convert(people);
        } else {
            Page<Person> people = personRepository.findByName(name, pageable);
            return PersonDTO.convert(people);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PersonDTO> insert(@RequestBody @Valid PersonForm form, UriComponentsBuilder uriBuilder) {
        Person person = form.convert();
        personRepository.save(person);

        URI uri = uriBuilder.path("/person/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).body(new PersonDTO(person));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody @Valid PersonForm form) {
        Optional<Person> optional = personRepository.findById(id);
        if (optional.isPresent()) {
            Person person = form.update(optional.get());
            personRepository.save(person);
            return ResponseEntity.ok(new PersonDTO(person));
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> detail(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person
                .map(value -> ResponseEntity.ok(new PersonDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<Person> optional = personRepository.findById(id);
        if (optional.isPresent()) {
            personRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}