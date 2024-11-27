package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvShowSerialGoods_Table",
        procedureName = "InvShowSerialGoods_Table",
        resultClasses = {InvSerialGoodsTable.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

//
//@NamedStoredProcedureQuery(
//        name = "InvUpdSerialGoods",
//        procedureName = "InvUpdSerialGoods",
//        resultClasses = {InvSerialGoodsTable.class},
//        parameters = {
//                @StoredProcedureParameter(name = "SerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "SerialGoodsDesc", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "SerialQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field1", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field2", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field3", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field4", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field5", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field6", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field7", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field8", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field9", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Field10", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "RefSerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "BaseSerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN)
//        })
//
//@NamedStoredProcedureQuery(
//        name = "InvDelSerialGoods",
//        procedureName = "InvDelSerialGoods",
//        resultClasses = {InvSerialGoodsTable.class},
//        parameters = {
//                @StoredProcedureParameter(name = "SerialGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT),
//        }
//)


@Entity
public class InvSerialGoodsTable extends TParams implements Serializable {

    @Id
    @Column(name = "SerialGoodsID")
    private BigDecimal serialGoodsID;

    @Column(name = "BaseSerialGoodsID")
    private BigDecimal baseSerialGoodsID;

    @Column(name = "SerialGoodsDesc")
    private String serialGoodsDesc;

    @Column(name = "SerialQuantity")
    private BigDecimal serialQuantity;

    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "Field1")
    private String field1;

    @Column(name = "Field2")
    private String field2;

    @Column(name = "Field3")
    private String field3;

    @Column(name = "Field4")
    private String field4;


    @Column(name = "Field5")
    private String field5;

    @Column(name = "Field6")
    private String field6;

    @Column(name = "Field7")
    private String field7;

    @Column(name = "Field8")
    private String field8;

    @Column(name = "Field9")
    private String field9;

    @Column(name = "Field10")
    private String field10;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

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


    @Column(name = "RefSerialGoodsID")
    private BigDecimal refSerialGoodsID;


    @Column(name = "BuyID")
    private BigDecimal buyID;

    @Column(name = "SaleID")
    private BigDecimal saleID;

    @Column(name = "MppID")
    private BigDecimal mppID;

    @Transient
    @Column(name = "RowID")
    private String rowID;

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

    public String getSerialGoodsDesc() {
        return serialGoodsDesc;
    }

    public void setSerialGoodsDesc(String serialGoodsDesc) {
        this.serialGoodsDesc = serialGoodsDesc;
    }

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

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
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

    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }
}
