package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.AddressDto;
import cm.uni2grow.digitalinvoicing.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

//@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto fromEntityToDto(Address address);
    Address fromDtoToEntity(AddressDto addressDto);
}
