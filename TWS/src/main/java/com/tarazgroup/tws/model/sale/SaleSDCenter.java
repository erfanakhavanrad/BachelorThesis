package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedNativeQueries({
        @NamedNativeQuery(name = "DeliveryCenter", query = "SELECT * FROM SaleSDCenter WHERE IsDeliveryCenter= 1 AND ISNULL(IsNotActive,0) = 0",resultClass = SaleSDCenter.class),
        @NamedNativeQuery(name = "SaleCenter", query = "SELECT * FROM SaleSDCenter WHERE IsSaleCenter = 1 AND ISNULL(IsNotActive,0) = 0",resultClass = SaleSDCenter.class)
})
@Entity
@Table(name = "SaleSDCenter")
public class SaleSDCenter extends TParams implements Serializable {

    @Id
    @Column(name = "SDCenterID", columnDefinition = "decimal")
    private BigDecimal sDCenterID;

    @Column(name = "IsSaleCenter", columnDefinition = "bit")
    @Parameter
    private Boolean isSaleCenter;

    @Column(name = "IsDeliveryCenter", columnDefinition = "bit")
    @Parameter
    private Boolean isDeliveryCenter;

    @Column(name = "SDCode", columnDefinition = "nvarchar")
    private String sDCode;

    @Column(name = "SDDesc", columnDefinition = "nvarchar")
    private String sDDesc;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    private BigDecimal modifierID;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    private BigDecimal creatorID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "IsNotActive", columnDefinition = "bit")
    private Boolean isNotActive;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getsDCenterID() {
        return sDCenterID;
    }

    public void setsDCenterID(BigDecimal sDCenterID) {
        this.sDCenterID = sDCenterID;
    }

    public Boolean getSaleCenter() {
        return isSaleCenter;
    }

    public void setSaleCenter(Boolean saleCenter) {
        isSaleCenter = saleCenter;
    }

    public Boolean getDeliveryCenter() {
        return isDeliveryCenter;
    }

    public void setDeliveryCenter(Boolean deliveryCenter) {
        isDeliveryCenter = deliveryCenter;
    }

    public String getsDCode() {
        return sDCode;
    }

    public void setsDCode(String sDCode) {
        this.sDCode = sDCode;
    }

    public String getsDDesc() {
        return sDDesc;
    }

    public void setsDDesc(String sDDesc) {
        this.sDDesc = sDDesc;
    }


    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Boolean getNotActive() {
        return isNotActive;
    }

    public void setNotActive(Boolean notActive) {
        isNotActive = notActive;
    }
}

