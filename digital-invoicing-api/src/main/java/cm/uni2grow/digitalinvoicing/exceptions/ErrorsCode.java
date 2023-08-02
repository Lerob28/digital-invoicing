package cm.uni2grow.digitalinvoicing.exceptions;

public enum ErrorsCode {
    ADDRESS_NOT_FOUND(1000),
    INVALID_ADDRESS(1001),

    CUSTOMER_NOT_FOUND(2000),
    INVALID_CUSTOMER(2001),

    INVOICE_NOT_FOUND(3000),
    INVALID_INVOICE(3001);

    // TODO : complete the rest of the list

    private int code;

    ErrorsCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}

