package cm.uni2grow.digitalinvoicing.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimpleCustomerDto {

    private Long id;

    private String name;

    private String email;

    private String phone;

}
