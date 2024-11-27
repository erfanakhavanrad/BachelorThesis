package com.tarazgroup.tws.dto.tkt;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 * @date Dec-15, 2021
 */
public class TktDepartmentDto implements Serializable {


    private String departmentName;

    private String departmentEmailAddress;

    private Boolean isVisibleForCustomers;

    private BigDecimal ticketTimeout;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentEmailAddress() {
        return departmentEmailAddress;
    }

    public void setDepartmentEmailAddress(String departmentEmailAddress) {
        this.departmentEmailAddress = departmentEmailAddress;
    }

    public Boolean getIsVisibleForCustomers() {
        return isVisibleForCustomers;
    }

    public void setIsVisibleForCustomers(Boolean isVisibleForCustomers) {
        this.isVisibleForCustomers = isVisibleForCustomers;
    }

    public BigDecimal getTicketTimeout() {
        return ticketTimeout;
    }

    public void setTicketTimeout(BigDecimal ticketTimeout) {
        this.ticketTimeout = ticketTimeout;
    }
}
