package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import cm.uni2grow.digitalinvoicing.entities.Address;
import cm.uni2grow.digitalinvoicing.exceptions.EntityNotFoundException;
import cm.uni2grow.digitalinvoicing.exceptions.ErrorsCode;
import cm.uni2grow.digitalinvoicing.exceptions.InvalidEntityException;
import cm.uni2grow.digitalinvoicing.mappers.AddressMapper;
import cm.uni2grow.digitalinvoicing.repositories.AddressRepository;
import cm.uni2grow.digitalinvoicing.validators.AddressValidator;
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
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    private AddressMapper addressMapper;
    @Override
    public AddressDto createAddress(AddressDto address) {
        List<String> errors = AddressValidator.validate(address);
        if (!errors.isEmpty()) {
            log.error("Error: Invalid Address ...");
            throw new InvalidEntityException("Invalid Address Given ...", ErrorsCode.INVALID_ADDRESS, errors);
        }
        Address savedAddress = addressRepository.save(addressMapper.fromDtoToEntity(address));
        return addressMapper.fromEntityToDto(savedAddress);
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto address) {
        AddressDto addressDto = getAddressByID(addressId);
        Address addressToUpdate = Address.builder()
                .id(addressDto.getId())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .state(address.getState())
                .street(address.getStreet())
                .build();
        return addressMapper.fromEntityToDto(addressRepository.save(addressToUpdate));
    }

    @Override
    public AddressDto getAddressByID(Long addressId) {
        if (addressId == null) {
            log.error("Error: Invalid Address Identifier ...");
            return null;
        }
        Optional<Address> address = addressRepository.findById(addressId);
        AddressDto addressDto = addressMapper.fromEntityToDto(address.get());
        return Optional.of(addressDto).orElseThrow(
            () ->  new EntityNotFoundException("No Address Found With ID "+addressId, ErrorsCode.INVALID_ADDRESS)
        );
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
            .map(addressMapper::fromEntityToDto)
            .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAddress(Long addressId) {
        System.out.println("attempt to delete Address with ID : "+addressId);
        if (addressId == null) {
            log.error("Error: Invalid Address Identifier ...");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        addressRepository.deleteById(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
