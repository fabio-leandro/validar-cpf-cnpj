package com.fabio.validacpfcnpjapi.resources;

import com.fabio.validacpfcnpjapi.domain.Person;
import com.fabio.validacpfcnpjapi.dtos.PersonDto;
import com.fabio.validacpfcnpjapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<PersonDto> getAll(){
        return personRepository.findAll()
                .stream().map(p -> PersonDto.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .email(p.getEmail())
                        .personType(p.getType())
                        .cpfOuCnpj(p.getCpfOuCnpj())
                        .build()
                ).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PersonDto> save(@Valid @RequestBody PersonDto personDto){
        Person person = new Person(personDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PersonDto(personRepository.save(person)));
    }
}
