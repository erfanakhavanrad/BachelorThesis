package com.tarazgroup.tws.util.global.responseheader;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class CtgDynamic implements Serializable {

    private final BigDecimal categoryID;

    private final String categoryName;

    private final Integer categoryPosition;

    public CtgDynamic(
            BigDecimal categoryID,
            String categoryName,
            Integer categoryPosition
    ) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryPosition = categoryPosition;
    }

    public BigDecimal getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getCategoryPosition() {
        return categoryPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CtgDynamic that = (CtgDynamic) o;
        return Objects.equals(categoryID, that.categoryID) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(categoryPosition, that.categoryPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryID, categoryName, categoryPosition);
    }
}
