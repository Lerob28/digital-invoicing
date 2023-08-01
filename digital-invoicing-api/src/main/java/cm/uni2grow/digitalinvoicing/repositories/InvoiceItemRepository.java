package cm.uni2grow.digitalinvoicing.repositories;

import cm.uni2grow.digitalinvoicing.entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
