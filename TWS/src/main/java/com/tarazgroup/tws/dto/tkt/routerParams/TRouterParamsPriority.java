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
public class TRouterParamsPriority extends TRouterParams {
    final private BigDecimal priorityID;

    public TRouterParamsPriority(BigDecimal priorityID) {
        this.priorityID = priorityID;
    }

    public BigDecimal getPriorityID() {
        return priorityID;
    }
}
