package com.tarazgroup.tws.util.global.responseheader;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class Origin implements Serializable {
    private final String resource;

    private final String pKName;

    private final String path;

    private final Object params;

    public Origin(
            String resource,
            String pKName,
            String path,
            Object params
    ) {
        this.resource = resource;
        this.pKName = pKName;
        this.path = path;
        this.params = params;
    }

    public String getResource() {
        return resource;
    }

    public String getPKName() {
        return pKName;
    }

    public String getPath() {
        return path;
    }

    public Object getParams() {
        return params;
    }

}
