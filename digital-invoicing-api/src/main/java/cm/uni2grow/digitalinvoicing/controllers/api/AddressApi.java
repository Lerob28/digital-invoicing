package cm.uni2grow.digitalinvoicing.controllers.api;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cm.uni2grow.digitalinvoicing.utils.Constants.APP_ROOT;

public interface AddressApi {
    @PostMapping(value = APP_ROOT+"/address/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AddressDto createAddress(@RequestBody AddressDto Address);

    @PutMapping(value = APP_ROOT+"/address/update/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AddressDto updateAddress(@PathVariable(value = "addressId") Long AddressId, @RequestBody AddressDto Address);

    @GetMapping(value = APP_ROOT+"/address/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AddressDto> getAllAddresss();

    @GetMapping(value = APP_ROOT+"/address/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    AddressDto findAddressById(@PathVariable(value = "addressId") Long AddressId);

    @DeleteMapping(value = APP_ROOT+"/address/delete/{addressId}")
    ResponseEntity<HttpStatus> deleteAddress(@PathVariable(value = "addressId") Long AddressId);

}
