package cm.uni2grow.digitalinvoicing.controllers;

import cm.uni2grow.digitalinvoicing.controllers.api.AddressApi;
import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import cm.uni2grow.digitalinvoicing.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AddressController implements AddressApi {
    @Autowired
    private AddressService addressService;

    @Override
    public AddressDto createAddress(AddressDto address) {

        return addressService.createAddress(address);
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto address) {
        return addressService.updateAddress(addressId, address);
    }

    @Override
    public List<AddressDto> getAllAddresss() {

        return addressService.getAllAddress();
    }

    @Override
    public AddressDto findAddressById(Long addressId) {

        return addressService.getAddressByID(addressId);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAddress(Long addressId) {
        return addressService.deleteAddress(addressId);
    }
}
