package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    InvoiceDto createInvoice(InvoiceDto invoice);
    InvoiceDto updateInvoice(InvoiceDto invoice);
    List<InvoiceDto> getAllInvoices();
    InvoiceDto findInvoiceById(Long invoiceId);
    InvoiceDto findInvoiceByNumber(String invoiceNumber);
    void deleteInvoice(Long invoiceId);
}
