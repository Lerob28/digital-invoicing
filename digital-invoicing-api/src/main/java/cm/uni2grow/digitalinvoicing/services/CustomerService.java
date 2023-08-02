package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customer);
    CustomerDto updateCustomer(CustomerDto customer);
    CustomerDto getCustomerByID(Long customerId);
    List<CustomerDto> getAllCustomers();
    void deleteCustomer(Long customerId);
}
