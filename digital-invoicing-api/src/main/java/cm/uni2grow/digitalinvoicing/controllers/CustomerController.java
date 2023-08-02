package cm.uni2grow.digitalinvoicing.controllers;

import cm.uni2grow.digitalinvoicing.controllers.api.CustomerApi;
import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import cm.uni2grow.digitalinvoicing.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CustomerDto updateCustomer(CustomerDto customer, Long customerId) {
        return customerService.updateCustomer(customer);
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
    public void deleteCustomer(Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
