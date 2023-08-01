package cm.uni2grow.digitalinvoicing.dtos;

import cm.uni2grow.digitalinvoicing.entities.Address;
import cm.uni2grow.digitalinvoicing.entities.Customer;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private Long id;

    private String invoiceNumber;

    private Double totalAmount;

    private Customer customer;

    private List<InvoiceItemDto> invoiceItems;

    private Address billingAddress;

}
