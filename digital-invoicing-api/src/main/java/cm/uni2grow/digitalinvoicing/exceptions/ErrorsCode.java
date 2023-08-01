package cm.uni2grow.digitalinvoicing.exceptions;

public enum ErrorsCode {
    ADDRESS_NOT_FOUND(100),
    INVALID_ADDRESS(101),

    INVOICE_NOT_FOUND(200),
    INVALID_INVOICE(201);

    // TODO : complete the rest of the list

    private int code;

    ErrorsCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}

