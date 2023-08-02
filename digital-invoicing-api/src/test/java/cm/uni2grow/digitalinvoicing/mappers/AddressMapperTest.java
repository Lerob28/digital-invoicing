package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import cm.uni2grow.digitalinvoicing.entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class AddressMapperTest {
    @Autowired
    private  AddressDto addressDto;

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void shouldMapAddress() {

        AddressDto addressDto = AddressDto.builder()
            .id(1l)
            .state("state")
            .city("city")
            .zipCode("zip_code")
            .country("country")
            .street("street")
            .build();

        System.out.println(addressDto.getCity());
        System.out.println(addressDto.getZipCode());
        System.out.println(addressDto.getCountry());

        Address address = addressMapper.INSTANCE.fromDtoToEntity(addressDto);
        System.out.println(address.getCity());
        System.out.println(address.getZipCode());
        System.out.println(address.getCountry());

        assertEquals(address.getCity(), "city");
        assertEquals(address.getZipCode(), "zip_code");
        assertEquals(address.getId(), 1L);
    }

}