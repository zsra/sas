package hu.zsra.enaplo.exception;

import org.springframework.http.HttpStatus;

public class InvalidTokenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public InvalidTokenException() {
        this.message = "Expired or invalid token";
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
