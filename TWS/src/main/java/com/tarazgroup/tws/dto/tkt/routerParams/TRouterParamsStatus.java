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
public class TRouterParamsStatus extends TRouterParams {
    final private BigDecimal statusID;
    public TRouterParamsStatus(BigDecimal statusID) {
        this.statusID = statusID;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }
}
