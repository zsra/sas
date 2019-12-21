package hu.zsra.enaplo.exception;

import org.springframework.http.HttpStatus;

public class UsernameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public UsernameException() {
        this.message = "Username is already in use";
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
