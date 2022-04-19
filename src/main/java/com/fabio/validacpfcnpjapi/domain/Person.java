package com.fabio.validacpfcnpjapi.domain;

import com.fabio.validacpfcnpjapi.dtos.PersonDto;
import com.fabio.validacpfcnpjapi.dtos.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Entity
@Table(name = "tb_persons")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private PersonType type;
    private String cpfOuCnpj;

    public Person (PersonDto personDto){
        this.id = personDto.getId();
        this.name = personDto.getName();
        this.email = personDto.getEmail();
        this.type = personDto.getPersonType();
        this.cpfOuCnpj = personDto.getCpfOuCnpj();
    }

}
