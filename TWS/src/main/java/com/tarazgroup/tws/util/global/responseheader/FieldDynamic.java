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
public class FieldDynamic implements Serializable {
    private final BigDecimal id;

    private final String name;

    private final String title;

    private final boolean visibility;

    private final boolean isRequired;

    private final boolean canDelete;

    private final Type type;

    private final boolean isActive;

    private final String cssStyle;

    private final int rowSpan;

    private final int colSpan;

    public FieldDynamic(
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
            int colSpan
    ) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.type = type;
        this.visibility = visibility;
        this.isRequired = isRequired;
        this.canDelete = canDelete;
        this.isActive = isActive;
        this.cssStyle = cssStyle;
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public boolean getIsRequired() {
        return isRequired;
    }

    public boolean getCanDelete() {
        return canDelete;
    }

    public Type getType() {
        return type;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public int getColSpan() {
        return colSpan;
    }
}
