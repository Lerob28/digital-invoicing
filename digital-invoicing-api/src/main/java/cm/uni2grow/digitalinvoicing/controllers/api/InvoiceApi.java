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
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = APP_ROOT+"/invoice/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<InvoiceDto> createInvoice(@RequestBody SimpleInvoiceDto simpleInvoiceDto);

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = APP_ROOT+"/invoice/update/{invoiceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto updateInvoice(@PathVariable(value = "invoiceId") Long invoiceId, @RequestBody InvoiceDto invoice);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = APP_ROOT+"/invoice/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<InvoiceDto> getAllInvoices();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = APP_ROOT+"/invoice/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto findInvoiceById(@PathVariable(value = "invoiceId") Long invoiceId);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = APP_ROOT+"/invoice/number/{invoiceNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    InvoiceDto findInvoiceByNumber(@PathVariable(value = "invoiceNumber") String invoiceNumber);

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = APP_ROOT+"/invoice/delete/{invoiceId}")
    ResponseEntity<HttpStatus> deleteInvoice(@PathVariable(value = "invoiceId") Long invoiceId);
}
