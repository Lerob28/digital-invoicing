package cm.uni2grow.digitalinvoicing.handlers;

import cm.uni2grow.digitalinvoicing.exceptions.ErrorsCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private Integer httpCode;

    private ErrorsCode code;

    private String message;

    private List<String> errors = new ArrayList<>();

}
