package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import cm.uni2grow.digitalinvoicing.entities.Invoice;
import cm.uni2grow.digitalinvoicing.exceptions.EntityNotFoundException;
import cm.uni2grow.digitalinvoicing.exceptions.ErrorsCode;
import cm.uni2grow.digitalinvoicing.exceptions.InvalidEntityException;
import cm.uni2grow.digitalinvoicing.mappers.InvoiceMapper;
import cm.uni2grow.digitalinvoicing.repositories.InvoiceRepository;
import cm.uni2grow.digitalinvoicing.validators.InvoiceValidator;

import jakarta.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
@Slf4j
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoice) {
        List<String> errors = InvoiceValidator.validate(invoice);
        if (!errors.isEmpty()) {
           log.error("Error: Invalid Invoice ...");
           throw new InvalidEntityException("Invalid Invoice Given ...", ErrorsCode.INVALID_INVOICE, errors);
        }
        Invoice savedInvoice = invoiceRepository.save(invoiceMapper.fromDtoToEntity(invoice));
        return invoiceMapper.fromEntityToDto(savedInvoice);
    }

    @Override
    public InvoiceDto updateInvoice(Long invoiceId, InvoiceDto invoice) {
        InvoiceDto invoiceDto = findInvoiceById(invoiceId);
        Invoice invoiceToUpdate = Invoice.builder()
            .id(invoiceDto.getId())
            .invoiceNumber(invoiceDto.getInvoiceNumber())
            .billingAddress(invoice.getBillingAddress())
            .totalAmount(invoice.getTotalAmount())
            .customer(invoice.getCustomer())
            .invoiceItems(invoiceMapper.fromDtoToEntity(invoice).getInvoiceItems())
            .build();

        return invoiceMapper.fromEntityToDto(invoiceRepository.save(invoiceToUpdate));
    }


    @Override
    public List<InvoiceDto> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return invoices.stream()
            .map(invoiceMapper::fromEntityToDto)
            .collect(Collectors.toList());
    }


    @Override
    public InvoiceDto findInvoiceById(Long invoiceId) {
        if (invoiceId == null) {
            log.error("Error: Invalid Invoice Identifier ...");
            return null;
        }
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        InvoiceDto invoiceDto = invoiceMapper.fromEntityToDto(invoice.get());
        return Optional.of(invoiceDto).orElseThrow(
            () ->  new EntityNotFoundException("No Invoice Found With ID "+invoiceId, ErrorsCode.INVOICE_NOT_FOUND)
        );
    }


    @Override
    public InvoiceDto findInvoiceByNumber(String invoiceNumber) {
        if (!StringUtils.hasLength(invoiceNumber)) {
            log.error("Error: Invalid Invoice Number ...");
            return null;
        }
        Optional<Invoice> invoice = invoiceRepository.findInvoiceByInvoiceNumber(invoiceNumber);
        InvoiceDto invoiceDto = invoiceMapper.fromEntityToDto(invoice.get());
        return Optional.of(invoiceDto).orElseThrow(
            () ->  new EntityNotFoundException("No Invoice Found With Number "+ invoiceNumber, ErrorsCode.INVOICE_NOT_FOUND)
        );
    }

    @Override
    public ResponseEntity<HttpStatus> deleteInvoice(Long invoiceId) {
        if (invoiceId == null) {
            log.error("Error: Invalid Invoice Identifier ...");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        invoiceRepository.deleteById(invoiceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}