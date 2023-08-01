package cm.uni2grow.digitalinvoicing.repositories;

import cm.uni2grow.digitalinvoicing.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
