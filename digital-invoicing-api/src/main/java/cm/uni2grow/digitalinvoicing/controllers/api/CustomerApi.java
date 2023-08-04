package cm.uni2grow.digitalinvoicing.controllers.api;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import cm.uni2grow.digitalinvoicing.dtos.SimpleCustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.uni2grow.digitalinvoicing.utils.Constants.APP_ROOT;

public interface CustomerApi {
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = APP_ROOT+"/customer/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto createCustomer(@RequestBody SimpleCustomerDto simpleCustomerDto);

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = APP_ROOT+"/customer/update/{customerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto updateCustomer(@PathVariable(value = "customerId") Long CustomerId, @RequestBody CustomerDto Customer);


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = APP_ROOT+"/customer/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CustomerDto> getAllCustomers();

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = APP_ROOT+"/customer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto findCustomerById(@PathVariable(value = "customerId") Long CustomerId);

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = APP_ROOT+"/customer/delete/{customerId}")
    ResponseEntity<HttpStatus> deleteCustomer(@PathVariable(value = "customerId") Long CustomerId);
}
