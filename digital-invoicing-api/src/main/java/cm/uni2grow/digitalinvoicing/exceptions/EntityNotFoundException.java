package cm.uni2grow.digitalinvoicing.exceptions;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException {

    @Getter
    private ErrorsCode errorsCode;

    private EntityNotFoundException(String message) {
        super(message);
    }
    private EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    private EntityNotFoundException(String message, Throwable cause, ErrorsCode errorsCode) {
        super(message, cause);
        this.errorsCode = errorsCode;
    }
    private EntityNotFoundException(String message, ErrorsCode errorsCode) {
        super(message);
        this.errorsCode = errorsCode;
    }
}
