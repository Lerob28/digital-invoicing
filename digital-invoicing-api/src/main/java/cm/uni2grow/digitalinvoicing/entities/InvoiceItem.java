package cm.uni2grow.digitalinvoicing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem extends AbstractEntity {

    private String name;
    private Double total;
    private Integer quantity;
    private Double price;
    @ManyToOne
    private Invoice invoice;

}
