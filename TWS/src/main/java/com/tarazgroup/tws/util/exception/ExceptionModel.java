package com.tarazgroup.tws.util.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * {@link ExceptionModel} Entity used in response
 * </p>
 * @author alireza_bayat
 * @since 2.0.0
 */
public class ExceptionModel implements Serializable {

    private String error;
    private String message;
    private String path;
    private int status;
    private Date timestamp;
    private List<HashMap<String,String>> errors = new ArrayList<>();

    public ExceptionModel(String error, String message, String path, int status) {
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
        this.timestamp = new Date();
    }

    public ExceptionModel(String error, String message, String path, int status, List<HashMap<String,String>> errors) {
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
        this.errors = errors;
        this.timestamp = new Date();
    }




    public List<HashMap<String,String>> getErrors() {
        return errors;
    }

    public void setErrors(List<HashMap<String,String>> errors) {
        this.errors = errors;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

