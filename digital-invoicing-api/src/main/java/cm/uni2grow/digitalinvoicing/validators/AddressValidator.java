package cm.uni2grow.digitalinvoicing.validators;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AddressValidator {
    public static List<String> validate(AddressDto addressDto) {
        List<String> errors = new ArrayList<>();

        if(addressDto == null) {
            errors.add("Vous ne pouvez enregistrer un Objet vide");
        }
        if(!StringUtils.hasLength(addressDto.getCity())) {
            errors.add("Veillez renseigner une adresse email");
        }
        return errors;
    }
}
