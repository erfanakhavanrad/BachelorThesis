package com.tarazgroup.tws.util.exception;

/**
 * 1/25/22
 *
 * @author Erfan Akhavan
 */
public class TktInvalidTokenException extends RuntimeException {
//    public TktInvalidTokenException(String message, Throwable cause) {
//        super(message, cause);
//    }
//
//    public TktInvalidTokenException() {
//        super();
//    }
//
//    public TktInvalidTokenException(String s) {
//    }

    public TktInvalidTokenException() {
    }

    public TktInvalidTokenException(String message) {
        super(message);
    }

}
