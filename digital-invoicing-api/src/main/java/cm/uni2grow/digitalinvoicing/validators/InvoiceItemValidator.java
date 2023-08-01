package cm.uni2grow.digitalinvoicing.validators;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceItemDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class InvoiceItemValidator {
    public static List<String> validate(InvoiceItemDto invoiceItemDto) {
        List<String> errors = new ArrayList<>();

        if(invoiceItemDto == null) {
            errors.add("Vous ne pouvez enregistrer un Objet vide");
        }
        if(!StringUtils.hasLength(String.valueOf(invoiceItemDto.getQuantity()))) {
            errors.add("Veillez renseigner une adresse email");
        }
        return errors;
    }
}
