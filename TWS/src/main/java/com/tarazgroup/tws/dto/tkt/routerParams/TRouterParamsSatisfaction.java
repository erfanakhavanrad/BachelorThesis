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
public class TRouterParamsSatisfaction extends TRouterParams {
    final private BigDecimal satisfactionID;

    public TRouterParamsSatisfaction(BigDecimal satisfactionID) {
        this.satisfactionID = satisfactionID;
    }

    public BigDecimal getSatisfactionID() {
        return satisfactionID;
    }
}
