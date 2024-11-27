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
public class MetaDynamic implements Serializable {
    private final ArrayList<Col> cols;

    private final ArrayList<CtgDynamic> ctgs;

    private final ArrayList<ArrayList<ArrayList>> fields;

    private final int dataEntryHeight;


    public MetaDynamic(
            ArrayList<Col> cols,
            ArrayList<CtgDynamic> ctgs,
            ArrayList<ArrayList<ArrayList>> fields,
            int dataEntryHeight
    ) {
        this.cols = cols;
        this.ctgs = ctgs;
        this.fields = fields;
        this.dataEntryHeight = dataEntryHeight;
    }

    public ArrayList<Col> getCols() {
        return cols;
    }

    public ArrayList<CtgDynamic> getCtgs() {
        return ctgs;
    }

    public ArrayList<ArrayList<ArrayList>> getFields() {
        return fields;
    }

    public int getDataEntryHeight() {
        return dataEntryHeight;
    }
}

