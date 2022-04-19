package com.fabio.validacpfcnpjapi.validations;

import com.fabio.validacpfcnpjapi.dtos.PersonDto;
import com.fabio.validacpfcnpjapi.dtos.enums.PersonType;
import com.fabio.validacpfcnpjapi.utils.BR;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class PersonInsertValidator implements ConstraintValidator<PersonInsert, PersonDto> {

    @Override
    public void initialize(PersonInsert personInsert) {
    }

    @Override
    public boolean isValid(PersonDto objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getPersonType().equals(PersonType.PF) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if (objDto.getPersonType().equals(PersonType.PJ) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
