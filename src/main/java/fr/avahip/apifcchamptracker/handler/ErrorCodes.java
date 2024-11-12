package fr.avahip.apifcchamptracker.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCodes {

    NO_CODE(0, "No code", NOT_IMPLEMENTED),
    INCORRECT_CURRENT_PASSWORD(300, "Current password is incorrect" ,BAD_REQUEST),
    NEW_PASSWORD_DOES_NOT_MATCH(301, "New password does not match" ,BAD_REQUEST),
    ACCOUNT_LOCKED(302, "User account is locked", FORBIDDEN),
    ACCOUNT_DISABLED(303, "User account is disabled" , FORBIDDEN),
    BAD_CREDENTIALS(304, "Login and/or password incorrect" , FORBIDDEN),;

    private final int code;
    private final String description;
    private final HttpStatus httpStatus;

    ErrorCodes(int code, String description, HttpStatus httpStatus) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}