package com.wallet.epay.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for handling bad requests.
 *
 * Author: Rajkumar Karnakar
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    /**
     * Default constructor.
     */
    public BadRequestException() {
        super();
    }

    /**
     * Constructor with a custom message.
     *
     * @param message the custom message
     */
    public BadRequestException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom message and cause.
     *
     * @param message the custom message
     * @param cause the cause of the exception
     */
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     *
     * @param cause the cause of the exception
     */
    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
