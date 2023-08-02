package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceItemDto;
import cm.uni2grow.digitalinvoicing.entities.InvoiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

//@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
@Mapper(componentModel = "spring")
public interface InvoiceItemMapper {
    InvoiceItemDto fromEntityToDto(InvoiceItem invoiceItem);
    InvoiceItem fromDtoToEntity(InvoiceItemDto invoiceItemDto);
}
