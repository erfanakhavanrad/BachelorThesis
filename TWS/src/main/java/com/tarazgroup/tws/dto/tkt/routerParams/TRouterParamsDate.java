package com.tarazgroup.tws.dto.tkt.routerParams;

import com.tarazgroup.tws.dto.router.TRouterParams;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class TRouterParamsDate extends TRouterParams {
    final private String createDate;

    final private String modifyDate;

    public TRouterParamsDate(String createDate, String modifyDate) {
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }
}
