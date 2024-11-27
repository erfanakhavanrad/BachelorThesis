package com.tarazgroup.tws.util.global.responseheader;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class Meta<T> implements Serializable {
    private final ArrayList<T> cols;

    public Meta(ArrayList<T> cols) {
        this.cols = cols;
    }

    public ArrayList<T> getCols() {
        return cols;
    }
}
