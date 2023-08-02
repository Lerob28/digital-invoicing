package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customer);
    CustomerDto updateCustomer(Long customerId, CustomerDto customer);
    CustomerDto getCustomerByID(Long customerId);
    List<CustomerDto> getAllCustomers();
    ResponseEntity<HttpStatus> deleteCustomer(Long customerId);
}
