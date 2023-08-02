package cm.uni2grow.digitalinvoicing.controllers;

import cm.uni2grow.digitalinvoicing.controllers.api.CustomerApi;
import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import cm.uni2grow.digitalinvoicing.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CustomerController implements CustomerApi {
    @Autowired
    private CustomerService customerService;
    @Override
    public CustomerDto createCustomer(CustomerDto customer) {
        return customerService.createCustomer(customer);
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto customer) {
        return customerService.updateCustomer(customerId, customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Override
    public CustomerDto findCustomerById(Long customerId) {
        return customerService.getCustomerByID(customerId);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCustomer(Long customerId) {
        return customerService.deleteCustomer(customerId);
    }
}
