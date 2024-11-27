package com.tarazgroup.tws.dto.tkt.ticket;

import com.tarazgroup.tws.dto.router.TRouterQuery;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class TRouterQueryTicket extends TRouterQuery {
    final private BigDecimal id;

    public TRouterQueryTicket(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }
}
