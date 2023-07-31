package cm.uni2grow.digitalinvoicing.entities;

import jakarta.persistence.*;
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
public class Invoice extends  AbstractEntity {

    private String invoiceNumber;

    private Double totalAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private List<InvoiceItem> invoiceItems;

    @OneToOne(fetch = FetchType.EAGER)
    private Address billingAddress;

}
