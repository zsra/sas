package hu.zsra.enaplo.exception;

import org.springframework.http.HttpStatus;

public class UserNotAuthenticatedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public UserNotAuthenticatedException(HttpStatus httpStatus) {
        this.message = "User not Authenticated";
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
