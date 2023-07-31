package cm.uni2grow.digitalinvoicing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address extends AbstractEntity {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;

}
