package cm.uni2grow.digitalinvoicing.mappers;

import cm.uni2grow.digitalinvoicing.dtos.InvoiceItemDto;
import cm.uni2grow.digitalinvoicing.entities.InvoiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceItemMapper {
    InvoiceItemMapper INSTANCE = Mappers.getMapper(InvoiceItemMapper.class);

    InvoiceItemDto fromEntityToDto(InvoiceItem invoiceItem);

    InvoiceItem fromDtoToEntity(InvoiceItemDto invoiceItemDto);

}
