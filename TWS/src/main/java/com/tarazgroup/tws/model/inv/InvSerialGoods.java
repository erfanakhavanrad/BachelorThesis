package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
        name = "InvSelectSerialGoods",
        procedureName = "InvSelectSerialGoods",
        resultClasses = {InvSerialGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeid", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RemainFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseDReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseRefTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelSerialGoods",
        procedureName = "InvDelSerialGoods",
        resultClasses = {InvSerialGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "SerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdSerialGoods",
        procedureName = "InvUpdSerialGoods",
        resultClasses = {InvSerialGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "SerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialGoodsDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field1", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field2", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field3", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field4", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field5", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field6", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field7", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field8", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field9", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Field10", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefSerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseSerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class InvSerialGoods extends TParams implements Serializable {

    @Id
    @Column(name = "SerialGoodsID")
    private BigDecimal serialGoodsID;

    @Column(name = "SerialGoodsDesc")
    @Parameter
    private String serialGoodsDesc;

    @Column(name = "SerialQuantity")
    @Parameter
    private BigDecimal serialQuantity;

    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "Field1")
    @Parameter
    private String field1;

    @Column(name = "Field2")
    @Parameter
    private String field2;

    @Column(name = "Field3")
    @Parameter
    private String field3;

    @Column(name = "Field4")
    @Parameter
    private String field4;

    @Column(name = "Field5")
    @Parameter
    private String field5;

    @Column(name = "Field6")
    @Parameter
    private String field6;

    @Column(name = "Field7")
    @Parameter
    private String field7;

    @Column(name = "Field8")
    @Parameter
    private String field8;

    @Column(name = "Field9")
    @Parameter
    private String field9;

    @Column(name = "Field10")
    @Parameter
    private String field10;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private java.util.Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private java.util.Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "BaseSerialGoodsID")
    @Parameter
    private BigDecimal baseSerialGoodsID;

    @Column(name = "RowID")
    @Parameter(hidden = true)
    private String rowID;

    @Column(name = "RefSerialGoodsID")
    @Parameter
    private BigDecimal refSerialGoodsID;

    @Column(name = "BuyID")
    private BigDecimal buyID;

    @Column(name = "SaleID")
    private BigDecimal saleID;

    @Column(name = "MppID")
    private BigDecimal mppID;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "SumQ")
    private BigDecimal sumQ;

    @Column(name = "RemainQ")
    private BigDecimal remainQ;

    @Column(name = "Remain2ndQ")
    private BigDecimal remain2ndQ;

    @Column(name = "IsUsed")
    private Boolean isUsed;

    @Column(name = "LastVTypeDesc")
    private String lastVTypeDesc;


    @Schema(accessMode = READ_ONLY)
    public BigDecimal getSerialGoodsID() {
        return serialGoodsID;
    }

    public void setSerialGoodsID(BigDecimal serialGoodsID) {
        this.serialGoodsID = serialGoodsID;
    }

    public BigDecimal getBaseSerialGoodsID() {
        return baseSerialGoodsID;
    }

    public void setBaseSerialGoodsID(BigDecimal baseSerialGoodsID) {
        this.baseSerialGoodsID = baseSerialGoodsID;
    }

    @NotBlank(message = "serialGoodsDesc is mandatory")
    @Schema(
            required = true,
            example = "1000025"
    )
    public String getSerialGoodsDesc() {
        return serialGoodsDesc;
    }

    public void setSerialGoodsDesc(String serialGoodsDesc) {
        this.serialGoodsDesc = serialGoodsDesc;
    }

    @NotNull(message = "serialQuantity is mandatory")
    @Schema(
            example = "1"
    )
    public BigDecimal getSerialQuantity() {
        return serialQuantity;
    }

    public void setSerialQuantity(BigDecimal serialQuantity) {
        this.serialQuantity = serialQuantity;
    }

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    @Schema(
            example = "10"
    )
    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Schema(
            example = "100"
    )
    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Schema(
            example = "1000"
    )
    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Schema(
            example = "1000"
    )
    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    @Schema(
            example = "1000"
    )
    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    @Schema(
            example = "1000"
    )
    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    @Schema(
            example = "1000"
    )
    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    @Schema(
            example = "1000"
    )
    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    @Schema(
            example = "1000"
    )
    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    @Schema(
            example = "1000"
    )
    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    public BigDecimal getRefSerialGoodsID() {
        return refSerialGoodsID;
    }

    public void setRefSerialGoodsID(BigDecimal refSerialGoodsID) {
        this.refSerialGoodsID = refSerialGoodsID;
    }

    public BigDecimal getBuyID() {
        return buyID;
    }

    public void setBuyID(BigDecimal buyID) {
        this.buyID = buyID;
    }

    public BigDecimal getSaleID() {
        return saleID;
    }

    public void setSaleID(BigDecimal saleID) {
        this.saleID = saleID;
    }

    public BigDecimal getMppID() {
        return mppID;
    }

    public void setMppID(BigDecimal mppID) {
        this.mppID = mppID;
    }

    @Schema(hidden = true)
    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public BigDecimal getSumQ() {
        return sumQ;
    }

    public void setSumQ(BigDecimal sumQ) {
        this.sumQ = sumQ;
    }

    public BigDecimal getRemainQ() {
        return remainQ;
    }

    public void setRemainQ(BigDecimal remainQ) {
        this.remainQ = remainQ;
    }

    public BigDecimal getRemain2ndQ() {
        return remain2ndQ;
    }

    public void setRemain2ndQ(BigDecimal remain2ndQ) {
        this.remain2ndQ = remain2ndQ;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean used) {
        isUsed = used;
    }

    public String getLastVTypeDesc() {
        return lastVTypeDesc;
    }

    public void setLastVTypeDesc(String lastVTypeDesc) {
        this.lastVTypeDesc = lastVTypeDesc;
    }
}
