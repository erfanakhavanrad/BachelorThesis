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
public class TRouterParamsUserStatus extends TRouterParams {
    final private BigDecimal fromUserID;

    final private BigDecimal toUserID;

    final private BigDecimal statusID;

    public TRouterParamsUserStatus(BigDecimal fromUserID, BigDecimal toUserID, BigDecimal statusID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.statusID = statusID;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }

    public BigDecimal getFromUserID() {
        return fromUserID;
    }

    public BigDecimal getToUserID() {
        return toUserID;
    }
}
