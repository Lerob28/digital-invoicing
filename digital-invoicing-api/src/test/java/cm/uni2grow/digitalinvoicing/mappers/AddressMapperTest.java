package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import cm.uni2grow.digitalinvoicing.entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class AddressMapperTest {

    @Autowired
    private  AddressDto addressDto;

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

        Address address = AddressMapper.INSTANCE.fromDtoToEntity(addressDto);

        assertEquals(address.getCity(), "city");
        assertEquals(address.getZipCode(), "zip_code");
        assertEquals(address.getId(), 1L);
    }

}