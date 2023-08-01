package cm.uni2grow.digitalinvoicing.exceptions;

import lombok.Getter;
import java.util.List;

public class InvalidEntityException extends RuntimeException {

    @Getter
    private ErrorsCode errorsCode;
    @Getter
    private List<String> errors;

    private InvalidEntityException(String message) {
        super(message);
    }
    private InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    private InvalidEntityException(String message, Throwable cause, ErrorsCode errorsCode) {
        super(message, cause);
        this.errorsCode = errorsCode;
    }
    private InvalidEntityException(String message, ErrorsCode errorsCode) {
        super(message);
        this.errorsCode = errorsCode;
    }
    private InvalidEntityException(String message, ErrorsCode errorsCode, List<String> errors) {
        super(message);
        this.errorsCode = errorsCode;
        this.errors = errors;
    }

}
