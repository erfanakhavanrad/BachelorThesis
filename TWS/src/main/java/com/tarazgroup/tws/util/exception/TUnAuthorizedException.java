package com.tarazgroup.tws.util.exception;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

public class TUnAuthorizedException extends RuntimeException{

    public TUnAuthorizedException() {
    }

    public TUnAuthorizedException(String message) {
        super(message);
    }
}
