package cm.uni2grow.digitalinvoicing.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemDto {

    private Long id;

    private String name;

    private Double total;

    private Integer quantity;

    private Double price;

    private InvoiceDto invoice;

}
