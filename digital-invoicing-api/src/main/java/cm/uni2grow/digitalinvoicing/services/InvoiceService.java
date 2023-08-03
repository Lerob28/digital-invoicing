package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import cm.uni2grow.digitalinvoicing.dtos.SimpleInvoiceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvoiceService {
    InvoiceDto createInvoice(SimpleInvoiceDto simpleInvoiceDto);
    InvoiceDto updateInvoice(Long invoiceId, InvoiceDto invoice);
    List<InvoiceDto> getAllInvoices();
    InvoiceDto findInvoiceById(Long invoiceId);
    InvoiceDto findInvoiceByNumber(String invoiceNumber);
    ResponseEntity<HttpStatus> deleteInvoice(Long invoiceId);
}
