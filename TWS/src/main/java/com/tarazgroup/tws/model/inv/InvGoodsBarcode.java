//package com.tarazgroup.tws.model.inv;
//
//import com.tarazgroup.tws.util.global.TParams;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//
///**
// * @author A.Farahani
// * Dec-21, 2021
// */
//
//@NamedStoredProcedureQuery(
//        name = "InvShowGoodsBarCode",
//        procedureName = "InvShowGoodsBarCode",
//        resultClasses = {InvGoodsBarcode.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "InvInsGoodsBarCode",
//        procedureName = "InvInsGoodsBarCode",
//        parameters = {
//                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "BarCode", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
//        }
//)
//
//@Entity
//public class InvGoodsBarcode extends TParams implements Serializable {
//    @Id
//    @Column(name = "mID")
//    private Integer mID;
//
//    @Column(name = "GoodsID")
//    private BigDecimal goodsID;
//
//    @Column(name = "BarCode")
//    private String barCode;
//
//    @Column(name = "ServerID")
//    private BigDecimal serverID;
//
//    @Column(name = "SecUnitID")
//    private BigDecimal secUnitID;
//
//    @Column(name = "SecUnitDesc")
//    private String secUnitDesc;
//
//    public BigDecimal getGoodsID() {
//        return goodsID;
//    }
//
//    public void setGoodsID(BigDecimal goodsID) {
//        this.goodsID = goodsID;
//    }
//
//    public String getBarCode() {
//        return barCode;
//    }
//
//    public void setBarCode(String barCode) {
//        this.barCode = barCode;
//    }
//
//    public BigDecimal getServerID() {
//        return serverID;
//    }
//
//    public void setServerID(BigDecimal serverID) {
//        this.serverID = serverID;
//    }
//
//    public BigDecimal getSecUnitID() {
//        return secUnitID;
//    }
//
//    public void setSecUnitID(BigDecimal secUnitID) {
//        this.secUnitID = secUnitID;
//    }
//
//    public String getSecUnitDesc() {
//        return secUnitDesc;
//    }
//
//    public void setSecUnitDesc(String secUnitDesc) {
//        this.secUnitDesc = secUnitDesc;
//    }
//
//    public Integer getmID() {
//        return mID;
//    }
//
//    public void setmID(Integer mID) {
//        this.mID = mID;
//    }
//}
