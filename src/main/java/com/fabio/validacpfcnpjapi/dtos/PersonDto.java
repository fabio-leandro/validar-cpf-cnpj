package com.fabio.validacpfcnpjapi.dtos;

import com.fabio.validacpfcnpjapi.domain.Person;
import com.fabio.validacpfcnpjapi.dtos.enums.PersonType;
import com.fabio.validacpfcnpjapi.validations.PersonInsert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@PersonInsert
public class PersonDto {

    private Integer id;
    private String name;
    private String email;
    private PersonType personType;
    private String cpfOuCnpj;

    public PersonDto (Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.personType = person.getType();
        this.cpfOuCnpj = person.getCpfOuCnpj();
    }

}
