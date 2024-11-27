package com.tarazgroup.tws.util.exception;

/**
 * 5/28/22
 *
 * @author Erfan Akhavan
 */
public class TOutOfTimeException extends RuntimeException {
    final private int status;

    public int getStatus() {
        return status;
    }

    public TOutOfTimeException(int status, String message) {
        super(message);
        this.status = status;

    }
}
