package cm.uni2grow.digitalinvoicing.repositories;

import cm.uni2grow.digitalinvoicing.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
