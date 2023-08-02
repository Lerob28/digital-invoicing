package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceDto;
import cm.uni2grow.digitalinvoicing.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

//@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceDto fromEntityToDto(Invoice invoice);
    Invoice fromDtoToEntity(InvoiceDto invoiceDto);
}
