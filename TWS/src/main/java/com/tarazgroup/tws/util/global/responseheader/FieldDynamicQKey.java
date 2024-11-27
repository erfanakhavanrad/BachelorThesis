package com.tarazgroup.tws.util.global.responseheader;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class FieldDynamicQKey extends FieldDynamic implements Serializable {
    private final String qKeyCode;

    private final String qKeyDesc;

    private final String qKeyCodeField;

    private final String qKeyDescField;


    public FieldDynamicQKey(
            BigDecimal id,
            String name,
            String title,
            Type type,
            boolean visibility,
            boolean isRequired,
            boolean canDelete,
            boolean isActive,
            String cssStyle,
            int rowSpan,
            int colSpan,
            String qKeyCode,
            String qKeyDesc,
            String qKeyCodeField,
            String qKeyDescField
    ) {
        super(id, name, title, type, visibility, isRequired, canDelete, isActive, cssStyle, rowSpan, colSpan);
        this.qKeyCode = qKeyCode;
        this.qKeyDesc = qKeyDesc;
        this.qKeyCodeField = qKeyCodeField;
        this.qKeyDescField = qKeyDescField;
    }

    public String getqKeyCode() {
        return qKeyCode;
    }

    public String getqKeyDesc() {
        return qKeyDesc;
    }

    public String getqKeyCodeField() {
        return qKeyCodeField;
    }

    public String getqKeyDescField() {
        return qKeyDescField;
    }
}
