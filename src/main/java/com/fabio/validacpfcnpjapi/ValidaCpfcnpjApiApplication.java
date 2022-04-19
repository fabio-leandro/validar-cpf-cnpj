package com.fabio.validacpfcnpjapi;

import com.fabio.validacpfcnpjapi.domain.Person;
import com.fabio.validacpfcnpjapi.dtos.enums.PersonType;
import com.fabio.validacpfcnpjapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ValidaCpfcnpjApiApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(ValidaCpfcnpjApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person p1 = Person.builder()
				.id(null)
				.name("Fábio Leandro Pinto")
				.email("fabio@gmail.com")
				.type(PersonType.PF)
				.cpfOuCnpj("01442219009")
				.build();

		Person p2 = Person.builder()
				.id(null)
				.name("LP Produções Criativas Ltda")
				.email("lp@gmail.com")
				.type(PersonType.PJ)
				.cpfOuCnpj("51131940000150")
				.build();

		personRepository.saveAll(List.of(p1,p2));

	}
}
