package com.tarazgroup.tws.model.mpp;

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
        name = "MppShowVoucherDetail",
        procedureName = "MppShowVoucherDetail",
        resultClasses = {MppVoucherDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "MppVoucherDetail")
public class MppVoucherDetail implements Serializable {

    @Id
    @Column(name = "VoucherDetailID")
    @Schema(accessMode = READ_ONLY)
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "SecUnitID")
    private BigDecimal secUnitID;

    @Column(name = "Quantity")
    @NotNull(message = "quantity is mandatory")
    private BigDecimal quantity;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "DReferID")
    private String dReferID;

    @Column(name = "ServerID")
    @Schema(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Schema(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Schema(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Schema(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Schema(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "DifferentialID")
    private BigDecimal differentialID;

    @Column(name = "SecUnitID2")
    private BigDecimal secUnitID2;

    @Column(name = "SecUnitID3")
    private BigDecimal secUnitID3;

    @Column(name = "Quantity2")
    private BigDecimal quantity2;

    @Column(name = "Quantity3")
    private BigDecimal quantity3;

    @Column(name = "Ratio2")
    private BigDecimal ratio2;

    @Column(name = "Ratio3")
    private BigDecimal ratio3;

    @Column(name = "Center1ID")
    private BigDecimal center1ID;

    @Column(name = "Center2ID")
    private BigDecimal center2ID;

    @Column(name = "Center3ID")
    private BigDecimal center3ID;

    @Column(name = "BaseDReferID")
    private BigDecimal baseDReferID;

    @Column(name = "RowNo")
    private BigDecimal rowNo;

    @Column(name = "AnalysisNo")
    private BigDecimal analysisNo;

    @Column(name = "AnalysisNos")
    private String analysisNos;

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public String getdReferID() {
        return dReferID;
    }

    public void setdReferID(String dReferID) {
        this.dReferID = dReferID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    public BigDecimal getDifferentialID() {
        return differentialID;
    }

    public void setDifferentialID(BigDecimal differentialID) {
        this.differentialID = differentialID;
    }

    public BigDecimal getSecUnitID2() {
        return secUnitID2;
    }

    public void setSecUnitID2(BigDecimal secUnitID2) {
        this.secUnitID2 = secUnitID2;
    }

    public BigDecimal getSecUnitID3() {
        return secUnitID3;
    }

    public void setSecUnitID3(BigDecimal secUnitID3) {
        this.secUnitID3 = secUnitID3;
    }

    public BigDecimal getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(BigDecimal quantity2) {
        this.quantity2 = quantity2;
    }

    public BigDecimal getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(BigDecimal quantity3) {
        this.quantity3 = quantity3;
    }

    public BigDecimal getRatio2() {
        return ratio2;
    }

    public void setRatio2(BigDecimal ratio2) {
        this.ratio2 = ratio2;
    }

    public BigDecimal getRatio3() {
        return ratio3;
    }

    public void setRatio3(BigDecimal ratio3) {
        this.ratio3 = ratio3;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getCenter1ID() {
        return center1ID;
    }

    public void setCenter1ID(BigDecimal center1ID) {
        this.center1ID = center1ID;
    }

    public BigDecimal getCenter2ID() {
        return center2ID;
    }

    public void setCenter2ID(BigDecimal center2ID) {
        this.center2ID = center2ID;
    }

    public BigDecimal getCenter3ID() {
        return center3ID;
    }

    public void setCenter3ID(BigDecimal center3ID) {
        this.center3ID = center3ID;
    }

    public BigDecimal getBaseDReferID() {
        return baseDReferID;
    }

    public void setBaseDReferID(BigDecimal baseDReferID) {
        this.baseDReferID = baseDReferID;
    }

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
    }

    public BigDecimal getAnalysisNo() {
        return analysisNo;
    }

    public void setAnalysisNo(BigDecimal analysisNo) {
        this.analysisNo = analysisNo;
    }

    public String getAnalysisNos() {
        return analysisNos;
    }

    public void setAnalysisNos(String analysisNos) {
        this.analysisNos = analysisNos;
    }
}
