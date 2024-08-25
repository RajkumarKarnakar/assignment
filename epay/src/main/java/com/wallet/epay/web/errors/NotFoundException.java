package com.wallet.epay.web.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for handling not found errors.
 *
 * Author: Rajkumar Karnakar
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    /**
     * Default constructor.
     */
    public NotFoundException() {
        super();
    }

    /**
     * Constructor with a custom message.
     *
     * @param message the custom message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom message and cause.
     *
     * @param message the custom message
     * @param cause the cause of the exception
     */
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     *
     * @param cause the cause of the exception
     */
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
