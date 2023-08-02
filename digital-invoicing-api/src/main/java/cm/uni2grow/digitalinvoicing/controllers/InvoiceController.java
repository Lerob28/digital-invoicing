package cm.uni2grow.digitalinvoicing.controllers;

import cm.uni2grow.digitalinvoicing.controllers.api.InvoiceApi;
import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import cm.uni2grow.digitalinvoicing.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController implements InvoiceApi {

    @Autowired
    private InvoiceService invoiceService;

    @Override
    public ResponseEntity<InvoiceDto> createInvoice(InvoiceDto invoice) {
         InvoiceDto invoiceDto = invoiceService.createInvoice(invoice);
        return new ResponseEntity<>(invoiceDto, HttpStatus.CREATED);
    }

    @Override
    public InvoiceDto updateInvoice(InvoiceDto invoice, Long invoiceId) {
        return invoiceService.updateInvoice(invoice);
    }

    @Override
    public List<InvoiceDto> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @Override
    public InvoiceDto findInvoiceById(Long invoiceId) {
        return invoiceService.findInvoiceById(invoiceId);
    }

    @Override
    public InvoiceDto findInvoiceByNumber(String invoiceNumber) {
        return invoiceService.findInvoiceByNumber(invoiceNumber);
    }

    @Override
    public void deleteInvoice(Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
    }

}
