package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import cm.uni2grow.digitalinvoicing.entities.Customer;
import cm.uni2grow.digitalinvoicing.exceptions.EntityNotFoundException;
import cm.uni2grow.digitalinvoicing.exceptions.ErrorsCode;
import cm.uni2grow.digitalinvoicing.exceptions.InvalidEntityException;
import cm.uni2grow.digitalinvoicing.mappers.CustomerMapper;
import cm.uni2grow.digitalinvoicing.repositories.CustomerRepository;
import cm.uni2grow.digitalinvoicing.validators.CustomerValidator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {
        List<String> errors = CustomerValidator.validate(customer);
        if (!errors.isEmpty()) {
            log.error("Error: Invalid Customer ...");
            throw new InvalidEntityException("Invalid Customer Given ...", ErrorsCode.INVALID_CUSTOMER, errors);
        }
        Customer savedCustomer = customerRepository.save(customerMapper.fromDtoToEntity(customer));
        return customerMapper.fromEntityToDto(savedCustomer);
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto customer) {
        CustomerDto customerDto = getCustomerByID(customerId);
        Customer customerToUpdate = Customer.builder()
                .id(customerDto.getId())
                .name(customer.getName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .build();
        return customerMapper.fromEntityToDto(customerRepository.save(customerToUpdate));
    }

    @Override
    public CustomerDto getCustomerByID(Long customerId) {
        if (customerId == null) {
            log.error("Error: Invalid Customer Identifier ...");
            return null;
        }
        Optional<Customer> customer = customerRepository.findById(customerId);
        CustomerDto customerDto = customerMapper.fromEntityToDto(customer.get());
        return Optional.of(customerDto).orElseThrow(
                () ->  new EntityNotFoundException("No Customer Found With ID "+customerId, ErrorsCode.INVALID_CUSTOMER)
        );
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
            .map(customerMapper::fromEntityToDto)
            .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCustomer(Long customerId) {
        if (customerId == null) {
            log.error("Error: Invalid Customer Identifier ...");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
