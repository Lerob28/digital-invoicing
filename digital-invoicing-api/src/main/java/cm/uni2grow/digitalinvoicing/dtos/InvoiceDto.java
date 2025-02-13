package cm.uni2grow.digitalinvoicing.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;

    private String invoiceNumber;

    private Double totalAmount;

    private CustomerDto customer;

    private List<InvoiceItemDto> invoiceItems;

    private AddressDto billingAddress;

}
