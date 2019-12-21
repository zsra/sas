package hu.zsra.enaplo.exception;

import org.springframework.http.HttpStatus;

public class InvalidSignInException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public InvalidSignInException() {
        this.message = "Invalid username/password supplied";
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
