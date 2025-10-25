package com.turkcell.product_service.core.exception;

public class ApplicationException extends RuntimeException {

    private final String errorCode;

    public ApplicationException(String message) {
        super(message);
        this.errorCode = null;
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }

    public ApplicationException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
