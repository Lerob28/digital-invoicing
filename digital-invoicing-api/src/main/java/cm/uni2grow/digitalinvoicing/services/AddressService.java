package cm.uni2grow.digitalinvoicing.services;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto address);
    AddressDto updateAddress(Long addressId, AddressDto address);
    AddressDto getAddressByID(Long addressId);
    List<AddressDto> getAllAddress();
    ResponseEntity<HttpStatus> deleteAddress(Long addressId);
}
