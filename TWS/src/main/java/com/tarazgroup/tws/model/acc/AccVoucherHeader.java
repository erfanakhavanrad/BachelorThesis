package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "AccShowVoucherHeader",
        procedureName = "AccShowVoucherHeader",
        resultClasses = {AccVoucherHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "GeneralFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerDBName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)
@NamedStoredProcedureQuery(
        name = "AccDeletedVoucherHeader",
        procedureName = "AccDeletedVoucherHeader",
        resultClasses = {AccVoucherHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "AccRestoreVoucherHeader",
        procedureName = "AccRestoreVoucherHeader",
        resultClasses = {AccVoucherHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelVoucherHeader",
        procedureName = "AccDelVoucherHeader",
        resultClasses = {AccVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccVoucherHeader extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID")
    @Parameter
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber")
    @Parameter
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    @Parameter
    private String voucherDate;

    @Column(name = "VoucherDateG")
    @Parameter
    private Date voucherDateG;

    @Column(name = "VoucherTime")
    @Parameter
    private String voucherTime;

    @Column(name = "VoucherDesc")
    @Parameter
    private String voucherDesc;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreateDateStr")
    @Parameter(hidden = true)
    private String createDateStr;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "CreatorName")
    @Parameter(hidden = true)
    private String creatorName;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifyDateStr")
    @Parameter(hidden = true)
    private String modifyDateStr;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "SerialCode")
    @Parameter
    private BigDecimal serialCode;

    @Column(name = "DayCode")
    @Parameter
    private BigDecimal dayCode;

    @Column(name = "SecondaryCode")
    @Parameter
    private BigDecimal secondaryCode;

    @Column(name = "ReferNumber")
    @Parameter
    private String referNumber;

    @Column(name = "ReferDate")
    @Parameter
    private String referDate;

    @Column(name = "VoucherStatID")
    @Parameter
    private BigDecimal voucherStatID;

    @Column(name = "VoucherStatDesc")
    @Parameter
    private String voucherStatDesc;

    @Column(name = "IsDeleted")
    @Parameter
    private Boolean isDeleted;

    @Column(name = "RefrenceNumber")
    @Parameter
    private String refrenceNumber;

    @Column(name = "CombineVoucherID")
    @Parameter
    private BigDecimal combineVoucherID;

    @Column(name = "IsTransfered")
    @Parameter
    private Boolean isTransfered;

    @Column(name = "VStatID")
    @Parameter(hidden = true)
    @Transient
    private BigDecimal vStatID;

    @Column(name = "ControllerName")
    @Parameter
    private String controllerName;

    @Column(name = "ReciverName")
    @Parameter
    private String reciverName;

    @Column(name = "VoucherTypeDesc")
    @Parameter
    private String voucherTypeDesc;

    @Column(name = "ServerDesc")
    @Parameter
    private String serverDesc;

    @Column(name = "SumVoucher")
    @Parameter
    private String sumVoucher;

    @Column(name = "BedBesStat")
    @Parameter
    private Integer bedBesStat;

    @Column(name = "ModifierName")
    @Parameter
    private String modifierName;

    @Column(name = "CombineNumber")
    @Parameter
    private BigDecimal combineNumber;

    @Column(name = "CustomVNo")
    @Parameter
    private BigDecimal customVNo;

    @Column(name = "CustomVDate")
    @Parameter
    private String customVDate;

    @Column(name = "CustomSNo")
    @Parameter
    private BigDecimal customSNo;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "RowID")
    @Parameter(hidden = true)
    private String rowID;

    public String getVoucherTime() {
        return voucherTime;
    }

    public void setVoucherTime(String voucherTime) {
        this.voucherTime = voucherTime;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifyDateStr() {
        return modifyDateStr;
    }

    public void setModifyDateStr(String modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
    }

    public String getVoucherStatDesc() {
        return voucherStatDesc;
    }

    public void setVoucherStatDesc(String voucherStatDesc) {
        this.voucherStatDesc = voucherStatDesc;
    }


    public Boolean getTransfered() {
        return isTransfered;
    }

    public void setTransfered(Boolean transfered) {
        this.isTransfered = transfered;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getReciverName() {
        return reciverName;
    }

    public void setReciverName(String reciverName) {
        this.reciverName = reciverName;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
    }

    public String getSumVoucher() {
        return sumVoucher;
    }

    public void setSumVoucher(String sumVoucher) {
        this.sumVoucher = sumVoucher;
    }

    public Integer getBedBesStat() {
        return bedBesStat;
    }

    public void setBedBesStat(Integer bedBesStat) {
        this.bedBesStat = bedBesStat;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public BigDecimal getCombineNumber() {
        return combineNumber;
    }

    public void setCombineNumber(BigDecimal combineNumber) {
        this.combineNumber = combineNumber;
    }

    public BigDecimal getCustomVNo() {
        return customVNo;
    }

    public void setCustomVNo(BigDecimal customVNo) {
        this.customVNo = customVNo;
    }

    public String getCustomVDate() {
        return customVDate;
    }

    public void setCustomVDate(String customVDate) {
        this.customVDate = customVDate;
    }

    public BigDecimal getCustomSNo() {
        return customSNo;
    }

    public void setCustomSNo(BigDecimal customSNo) {
        this.customSNo = customSNo;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    @Schema(accessMode = READ_ONLY)
    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    @NotNull(message = "voucherNumber is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    @NotNull(message = "voucherDate is mandatory")
    @Schema(
            required = true,
            example = "1399/02/13"
    )
    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    @Schema(
            example = "صدور سند خودکار"
    )
    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
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
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    @NotNull(message = "serialCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(BigDecimal serialCode) {
        this.serialCode = serialCode;
    }

    @NotNull(message = "serialCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getDayCode() {
        return dayCode;
    }

    public void setDayCode(BigDecimal dayCode) {
        this.dayCode = dayCode;
    }

    @Schema(
            example = "secondaryCode"
    )
    public BigDecimal getSecondaryCode() {
        return secondaryCode;
    }

    public void setSecondaryCode(BigDecimal secondaryCode) {
        this.secondaryCode = secondaryCode;
    }

    @Schema(
            example = "referNumber"
    )
    public String getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(String referNumber) {
        this.referNumber = referNumber;
    }

    @Schema(
            example = "referDate"
    )
    public String getReferDate() {
        return referDate;
    }

    public void setReferDate(String referDate) {
        this.referDate = referDate;
    }

    @NotNull(message = "voucherStatID is mandatory")
    @Schema(
            example = "voucherStatID"
    )
    public BigDecimal getVoucherStatID() {
        return voucherStatID;
    }

    public void setVoucherStatID(BigDecimal voucherStatID) {
        this.voucherStatID = voucherStatID;
    }

    @NotNull(message = "isDeleted is mandatory")
    @Schema(
            example = "true"
    )
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Schema(
            example = "refrenceNumber"
    )
    public String getRefrenceNumber() {
        return refrenceNumber;
    }

    public void setRefrenceNumber(String refrenceNumber) {
        this.refrenceNumber = refrenceNumber;
    }

    @Schema(
            example = "combineVoucherID"
    )
    public BigDecimal getCombineVoucherID() {
        return combineVoucherID;
    }

    public void setCombineVoucherID(BigDecimal combineVoucherID) {
        this.combineVoucherID = combineVoucherID;
    }

    @Schema(hidden = true)
    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    @Schema(
            example = "isTransfered"
    )
    public Boolean isTransfered() {
        return isTransfered;
    }

    @Schema(
            example = "vStatID"
    )
    public BigDecimal getvStatID() {
        return vStatID;
    }

    public void setvStatID(BigDecimal vStatID) {
        this.vStatID = vStatID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    @Schema(hidden = true)
    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }
}
