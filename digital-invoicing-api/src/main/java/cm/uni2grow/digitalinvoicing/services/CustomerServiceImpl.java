package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import cm.uni2grow.digitalinvoicing.dtos.SimpleCustomerDto;
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
    private AddressService addressService;

    @Override
    public CustomerDto createCustomer(SimpleCustomerDto simpleCustomerDto) {
        AddressDto addressDto = addressService.getAddressByID(simpleCustomerDto.getAddress());
        CustomerDto customerToSave = CustomerDto.builder()
                .name(simpleCustomerDto.getName())
                .phone(simpleCustomerDto.getPhone())
                .email(simpleCustomerDto.getEmail())
                .address(addressDto)
                .build();
        System.out.println("Customer to save ..........");
        System.out.println(customerToSave.toString());
        Customer savedCustomer = customerRepository.save(customerMapper.fromDtoToEntity(customerToSave));
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
