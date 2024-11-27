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
public class TRouterParamsOrganization extends TRouterParams {
    final private BigDecimal organizationID;
    final private String organizationName;


    public TRouterParamsOrganization(BigDecimal organizationID , String organizationName) {
        this.organizationID = organizationID;
        this.organizationName = organizationName;
    }

    public BigDecimal getOrganizationID() {
        return organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }
}
