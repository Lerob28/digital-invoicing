package cm.uni2grow.digitalinvoicing.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
public class AbstractEntity {

    /*@CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;*/

}
