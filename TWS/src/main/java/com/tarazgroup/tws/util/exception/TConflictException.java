package com.tarazgroup.tws.util.exception;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

public class TConflictException extends RuntimeException{
    final private int status;

    public int getStatus() {
        return status;
    }

    public TConflictException(int status , String message) {
        super(message);
        this.status=status;

    }
}
