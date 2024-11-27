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
public class FieldDynamicReferTo extends FieldDynamic implements Serializable {
    private final String referToCode;

    private final String referToDesc;


    public FieldDynamicReferTo(
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
            String referToCode,
            String referToDesc

    ) {
        super(id, name, title, type, visibility, isRequired, canDelete, isActive, cssStyle, rowSpan, colSpan);
        this.referToCode = referToCode;
        this.referToDesc = referToDesc;
    }

    public String getReferToCode() {
        return referToCode;
    }

    public String getReferToDesc() {
        return referToDesc;
    }
}
