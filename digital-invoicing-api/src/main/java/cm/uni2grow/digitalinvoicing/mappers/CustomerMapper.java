package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.CustomerDto;
import cm.uni2grow.digitalinvoicing.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

//@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto fromEntityToDto(Customer customer);
    Customer fromDtoToEntity(CustomerDto customerDto);
}
