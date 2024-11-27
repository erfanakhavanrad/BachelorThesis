package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowOtherInfo",
        procedureName = "SaleShowOtherInfo",
        resultClasses = {SaleOtherInfo.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsOtherInfo",
        procedureName = "SaleInsOtherInfo",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContractNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContractDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BruntNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CarNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DistNameID", type = BigDecimal.class, mode = ParameterMode.IN),

        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdOtherInfo",
        procedureName = "SaleUpdOtherInfo",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContractNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContractDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BruntNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CarNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "XDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DistNameID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleOtherInfo extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "ContractNumber")
    private String contractNumber;

    @Column(name = "ContractDate")
    private String contractDate;

    @Column(name = "BruntNumber")
    private String bruntNumber;

    @Column(name = "CarNumber")
    private String carNumber;

    @Column(name = "OtherDesc")
    private String otherDesc;

    @Column(name = "XDesc")
    private String XDesc;

    @Column(name = "DriverID")
    private BigDecimal driverID;

    @Column(name = "DriverName")
    private String driverName;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "DistNameID")
    private BigDecimal distNameID;

    @Column(name = "DistName")
    private String distName;

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getBruntNumber() {
        return bruntNumber;
    }

    public void setBruntNumber(String bruntNumber) {
        this.bruntNumber = bruntNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }

    public String getXDesc() {
        return XDesc;
    }

    public void setXDesc(String XDesc) {
        this.XDesc = XDesc;
    }

    public BigDecimal getDriverID() {
        return driverID;
    }

    public void setDriverID(BigDecimal driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getDistNameID() {
        return distNameID;
    }

    public void setDistNameID(BigDecimal distNameID) {
        this.distNameID = distNameID;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }
}
