package com.tarazgroup.tws.dto.tkt.routerParams;

import com.tarazgroup.tws.dto.router.TRouterParams;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class TRouterParamsDepartment extends TRouterParams {
    final private BigDecimal fromDepartmentID;

    final private BigDecimal toDepartmentID;

    public TRouterParamsDepartment(BigDecimal fromDepartmentID, BigDecimal toDepartmentID) {
        this.fromDepartmentID = fromDepartmentID;
        this.toDepartmentID = toDepartmentID;
    }

    public BigDecimal getFromDepartmentID() {
        return fromDepartmentID;
    }

    public BigDecimal getToDepartmentID() {
        return toDepartmentID;
    }
}
