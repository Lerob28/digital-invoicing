package cm.uni2grow.digitalinvoicing.controllers.api;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.uni2grow.digitalinvoicing.utils.Constants.APP_ROOT;

public interface CustomerApi {
    @PostMapping(value = APP_ROOT+"/customer/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto createCustomer(@RequestBody CustomerDto Customer);

    @PutMapping(value = APP_ROOT+"/customer/update/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto updateCustomer(@RequestBody CustomerDto Customer, @PathVariable(value = "customerId") Long CustomerId);

    @GetMapping(value = APP_ROOT+"/customer/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDto> getAllCustomers();

    @GetMapping(value = APP_ROOT+"/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto findCustomerById(@PathVariable(value = "customerId") Long CustomerId);

    @DeleteMapping(value = APP_ROOT+"customer/delete/{customerId}")
    void deleteCustomer(@PathVariable(value = "customerId") Long CustomerId);
}
