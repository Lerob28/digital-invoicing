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
public class SimpleInvoiceDto {

    private Long id;

    private String invoiceNumber;

    private Double totalAmount;

    private Long customer;

    private List<InvoiceItemDto> invoiceItems;

    private Long address;

}
