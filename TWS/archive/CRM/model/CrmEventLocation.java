package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmShowEventLocation",
        procedureName = "CrmShowEventLocation",
        resultClasses = {CrmEventLocation.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmEventLocation extends TParams implements Serializable {
    @Id
    @Column(name = "LocationID")
    private BigDecimal locationID;

    @Column(name = "LocationDesc")
    private String locationDesc;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    public BigDecimal getLocationID() {
        return locationID;
    }

    public void setLocationID(BigDecimal locationID) {
        this.locationID = locationID;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}























