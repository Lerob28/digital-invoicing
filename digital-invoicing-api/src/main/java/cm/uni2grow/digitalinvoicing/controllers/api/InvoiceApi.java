package cm.uni2grow.digitalinvoicing.controllers.api;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import static cm.uni2grow.digitalinvoicing.utils.Constants.APP_ROOT;

import cm.uni2grow.digitalinvoicing.dtos.SimpleInvoiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface InvoiceApi {
    @PostMapping(value = APP_ROOT+"/invoice/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<InvoiceDto> createInvoice(@RequestBody SimpleInvoiceDto simpleInvoiceDto);

    @PutMapping(value = APP_ROOT+"/invoice/update/{invoiceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto updateInvoice(@PathVariable(value = "invoiceId") Long invoiceId, @RequestBody InvoiceDto invoice);

    @GetMapping(value = APP_ROOT+"/invoice/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<InvoiceDto> getAllInvoices();

    @GetMapping(value = APP_ROOT+"/invoice/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto findInvoiceById(@PathVariable(value = "invoiceId") Long invoiceId);

    @GetMapping(value = APP_ROOT+"/invoice/number/{invoiceNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto findInvoiceByNumber(@PathVariable(value = "invoiceNumber") String invoiceNumber);

    @DeleteMapping(value = APP_ROOT+"/invoice/delete/{invoiceId}")
    ResponseEntity<HttpStatus> deleteInvoice(@PathVariable(value = "invoiceId") Long invoiceId);
}
