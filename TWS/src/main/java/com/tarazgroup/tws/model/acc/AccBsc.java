package com.tarazgroup.tws.model.acc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "Web_SP_Load_Inf_WebService_Taraz_BSC",
        procedureName = "Web_SP_Load_Inf_WebService_Taraz_BSC",
        resultClasses = {AccBsc.class},
        parameters = {
                @StoredProcedureParameter(name = "FLD_DateF", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FLD_DateL", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CostType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepType", type = Integer.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccBsc extends TParams implements Serializable {

    @Id
    @Column(name = "mID")
    @JsonIgnore
    private BigDecimal mID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "ServerName")
    private String serverName;

    @Column(name = "CostType")
    private Integer costType;

    @Column(name = "CostDesc")
    private String costDesc;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getCostDesc() {
        return costDesc;
    }

    public void setCostDesc(String costDesc) {
        this.costDesc = costDesc;
    }
}
