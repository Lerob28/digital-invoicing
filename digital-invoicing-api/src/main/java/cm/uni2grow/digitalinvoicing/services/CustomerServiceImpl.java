package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto createCustomer(CustomerDto customer) {
        return null;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customer) {
        return null;
    }

    @Override
    public CustomerDto getCustomerByID(Long customerId) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }
}
