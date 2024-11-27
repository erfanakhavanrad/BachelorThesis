package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;

/**
 * @author Salman Majidi
 * @since v2.0.0
 */
@NamedStoredProcedureQuery(
        name = "InvShowVoucherDetail_Image",
        procedureName = "InvShowVoucherDetail_Image",
        resultClasses = {InvVoucherDetailImage.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@Entity
public class InvVoucherDetailImage extends TParams implements Serializable {

    // این مدل برای اجرای گزارش کریستال کالاهای مرجع فارمد ساخته شده است
    @Id
    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "FeeAgreement")
    private BigDecimal feeAgreement;

    @Column(name = "RemainQ")
    private BigDecimal remainQ;

    @Column(name = "ImageGoods")
    private byte[] imageGoods;

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
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

    public BigDecimal getFeeAgreement() {
        return feeAgreement;
    }

    public void setFeeAgreement(BigDecimal feeAgreement) {
        this.feeAgreement = feeAgreement;
    }

    public BigDecimal getRemainQ() {
        return remainQ;
    }

    public void setRemainQ(BigDecimal remainQ) {
        this.remainQ = remainQ;
    }

    public byte[] getImageGoods() {
        return imageGoods;
    }

    public void setImageGoods(byte[] imageGoods) {
        this.imageGoods = imageGoods;
    }
}
