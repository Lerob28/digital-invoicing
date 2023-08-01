package cm.uni2grow.digitalinvoicing.validators;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class InvoiceValidator {
    public static List<String> validate(InvoiceDto invoiceDto) {
        List<String> errors = new ArrayList<>();

        if(invoiceDto == null) {
            errors.add("Vous ne pouvez enregistrer un Objet vide");
        }
        if(!StringUtils.hasLength(invoiceDto.getInvoiceNumber())) {
            errors.add("Veillez renseigner le code de la facture !");
        }
        return errors;
    }
}
