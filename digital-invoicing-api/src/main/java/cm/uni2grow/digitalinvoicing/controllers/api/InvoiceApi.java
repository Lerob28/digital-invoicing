package cm.uni2grow.digitalinvoicing.controllers.api;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import static cm.uni2grow.digitalinvoicing.utils.Constants.APP_ROOT;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InvoiceApi {
    @PostMapping(value = APP_ROOT+"/invoice/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<InvoiceDto> createInvoice(@RequestBody InvoiceDto invoice);

    @PutMapping(value = APP_ROOT+"/invoice/update/{invoiceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto updateInvoice(@RequestBody InvoiceDto invoice, @PathVariable(value = "invoiceId") Long invoiceId);

    @GetMapping(value = APP_ROOT+"/invoice/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<InvoiceDto> getAllInvoices();

    @GetMapping(value = APP_ROOT+"/invoice/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto findInvoiceById(@PathVariable(value = "invoiceId") Long invoiceId);

    @GetMapping(value = APP_ROOT+"/invoice/number/{invoiceNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto findInvoiceByNumber(@PathVariable(value = "invoiceNumber") String invoiceNumber);

    @DeleteMapping(value = APP_ROOT+"invoice/delete/{invoiceId}")
    void deleteInvoice(@PathVariable(value = "invoiceId") Long invoiceId);
}
