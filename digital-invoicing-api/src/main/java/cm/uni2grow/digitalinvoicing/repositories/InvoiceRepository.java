package cm.uni2grow.digitalinvoicing.repositories;

import cm.uni2grow.digitalinvoicing.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findInvoiceByInvoiceNumber(String invoiceNumber);

}
