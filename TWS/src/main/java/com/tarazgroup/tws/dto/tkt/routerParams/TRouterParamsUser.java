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
public class TRouterParamsUser extends TRouterParams {
    final private BigDecimal fromUserID;

    final private BigDecimal toUserID;

    public TRouterParamsUser(BigDecimal fromUserID, BigDecimal toUserID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    public BigDecimal getFromUserID() {
        return fromUserID;
    }

    public BigDecimal getToUserID() {
        return toUserID;
    }
}
