package cm.uni2grow.digitalinvoicing.validators;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomerValidator {
    public static List<String> validate(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();

        if(customerDto == null) {
            errors.add("Vous ne pouvez enregistrer un Objet vide");
        }
        if(!StringUtils.hasLength(customerDto.getEmail())) {
            errors.add("Veillez renseigner une adresse email");
        }
        return errors;
    }
}
