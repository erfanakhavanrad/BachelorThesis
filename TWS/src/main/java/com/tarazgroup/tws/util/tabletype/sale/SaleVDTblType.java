package com.tarazgroup.tws.util.tabletype.sale;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
// نکته بسیار مهم : حتما حتما ترتیب فیلد های این کلاس باید همانند ترتیب تیبل تایپ اس کیو ال باشد
public class SaleVDTblType {
    private BigDecimal rowNo;

    private BigDecimal voucherDetailID;

    private BigDecimal voucherHeaderID;

    private BigDecimal goodsID;

    private BigDecimal secUnitID;

    private BigDecimal quantity;

    private BigDecimal fee;

    private String detailXDesc;

    private BigDecimal dReferID;

    private BigDecimal creatorID;

    private BigDecimal modifierID;

    private BigDecimal differentialID;

    private BigDecimal computeValue;

    private String customField1;

    private String customField2;

    private String customField3;

    private String customField4;

    private String customField5;

    private String customField6;

    private String customField7;

    private String customField8;

    private String customField9;

    private String customField10;

    private BigDecimal customField11;

    private BigDecimal feeAgreement;

    private BigDecimal feeDiscountPrice;

    private BigDecimal feeDiscountPercent;

    private BigDecimal feeFrieghtCharges;

    private BigDecimal allocatedQuantity2;

    private BigDecimal overAllocatedQuantity2;

    private BigDecimal lCReferID;

    private BigDecimal agrReferID;

    private BigDecimal quantity2;

    private BigDecimal quantity3;

    private BigDecimal secUnitID2;

    private BigDecimal secUnitID3;

    private String customField12;

    private String customField13;

    private String customField14;

    private String customField15;

    private String customField16;

    private String customField17;

    private String customField18;

    private String customField19;

    private String customField20;

    private String customField21;

    private String customField22;

    private String customField23;

    private String customField24;

    private String customField25;

    private BigDecimal storeID;

    private BigDecimal center1ID;

    private BigDecimal center2ID;

    private BigDecimal center3ID;

    private String iGUID;

    private BigDecimal taxMab;

    private BigDecimal tollMab;

    private BigDecimal taxCoEff;

    private Boolean isPromotion;

    private BigDecimal baseDReferID;

    private BigDecimal secondGoodsID;

    private BigDecimal rRowMabPrice;

    private BigDecimal rRowMabPercent;

    private BigDecimal tollCoEff;

    private BigDecimal currencyID;

    private BigDecimal analysisNo;

    public void setlCReferID(BigDecimal lCReferID) {
        this.lCReferID = lCReferID;
    }

    public Boolean getPromotion() {
        return isPromotion;
    }

    public void setPromotion(Boolean promotion) {
        isPromotion = promotion;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
    }

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

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public BigDecimal getdReferID() {
        return dReferID;
    }

    public void setdReferID(BigDecimal dReferID) {
        this.dReferID = dReferID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
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

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField5() {
        return customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField6() {
        return customField6;
    }

    public void setCustomField6(String customField6) {
        this.customField6 = customField6;
    }

    public String getCustomField7() {
        return customField7;
    }

    public void setCustomField7(String customField7) {
        this.customField7 = customField7;
    }

    public String getCustomField8() {
        return customField8;
    }

    public void setCustomField8(String customField8) {
        this.customField8 = customField8;
    }

    public String getCustomField9() {
        return customField9;
    }

    public void setCustomField9(String customField9) {
        this.customField9 = customField9;
    }

    public String getCustomField10() {
        return customField10;
    }

    public void setCustomField10(String customField10) {
        this.customField10 = customField10;
    }

    public BigDecimal getCustomField11() {
        return customField11;
    }

    public void setCustomField11(BigDecimal customField11) {
        this.customField11 = customField11;
    }

    public BigDecimal getFeeAgreement() {
        return feeAgreement;
    }

    public void setFeeAgreement(BigDecimal feeAgreement) {
        this.feeAgreement = feeAgreement;
    }

    public BigDecimal getFeeDiscountPrice() {
        return feeDiscountPrice;
    }

    public void setFeeDiscountPrice(BigDecimal feeDiscountPrice) {
        this.feeDiscountPrice = feeDiscountPrice;
    }

    public BigDecimal getFeeDiscountPercent() {
        return feeDiscountPercent;
    }

    public void setFeeDiscountPercent(BigDecimal feeDiscountPercent) {
        this.feeDiscountPercent = feeDiscountPercent;
    }

    public BigDecimal getFeeFrieghtCharges() {
        return feeFrieghtCharges;
    }

    public void setFeeFrieghtCharges(BigDecimal feeFrieghtCharges) {
        this.feeFrieghtCharges = feeFrieghtCharges;
    }

    public BigDecimal getAllocatedQuantity2() {
        return allocatedQuantity2;
    }

    public void setAllocatedQuantity2(BigDecimal allocatedQuantity2) {
        this.allocatedQuantity2 = allocatedQuantity2;
    }

    public BigDecimal getOverAllocatedQuantity2() {
        return overAllocatedQuantity2;
    }

    public void setOverAllocatedQuantity2(BigDecimal overAllocatedQuantity2) {
        this.overAllocatedQuantity2 = overAllocatedQuantity2;
    }

    public BigDecimal getlCReferID() {
        return lCReferID;
    }

    public void setLCReferID(BigDecimal lCReferID) {
        this.lCReferID = lCReferID;
    }

    public BigDecimal getAgrReferID() {
        return agrReferID;
    }

    public void setAgrReferID(BigDecimal agrReferID) {
        this.agrReferID = agrReferID;
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

    public String getCustomField12() {
        return customField12;
    }

    public void setCustomField12(String customField12) {
        this.customField12 = customField12;
    }

    public String getCustomField13() {
        return customField13;
    }

    public void setCustomField13(String customField13) {
        this.customField13 = customField13;
    }

    public String getCustomField14() {
        return customField14;
    }

    public void setCustomField14(String customField14) {
        this.customField14 = customField14;
    }

    public String getCustomField15() {
        return customField15;
    }

    public void setCustomField15(String customField15) {
        this.customField15 = customField15;
    }

    public String getCustomField16() {
        return customField16;
    }

    public void setCustomField16(String customField16) {
        this.customField16 = customField16;
    }

    public String getCustomField17() {
        return customField17;
    }

    public void setCustomField17(String customField17) {
        this.customField17 = customField17;
    }

    public String getCustomField18() {
        return customField18;
    }

    public void setCustomField18(String customField18) {
        this.customField18 = customField18;
    }

    public String getCustomField19() {
        return customField19;
    }

    public void setCustomField19(String customField19) {
        this.customField19 = customField19;
    }

    public String getCustomField20() {
        return customField20;
    }

    public void setCustomField20(String customField20) {
        this.customField20 = customField20;
    }

    public String getCustomField21() {
        return customField21;
    }

    public void setCustomField21(String customField21) {
        this.customField21 = customField21;
    }

    public String getCustomField22() {
        return customField22;
    }

    public void setCustomField22(String customField22) {
        this.customField22 = customField22;
    }

    public String getCustomField23() {
        return customField23;
    }

    public void setCustomField23(String customField23) {
        this.customField23 = customField23;
    }

    public String getCustomField24() {
        return customField24;
    }

    public void setCustomField24(String customField24) {
        this.customField24 = customField24;
    }

    public String getCustomField25() {
        return customField25;
    }

    public void setCustomField25(String customField25) {
        this.customField25 = customField25;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
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

    public String getiGUID() {
        return iGUID;
    }

    public void setiGUID(String iGUID) {
        this.iGUID = iGUID;
    }

    public BigDecimal getTaxMab() {
        return taxMab;
    }

    public void setTaxMab(BigDecimal taxMab) {
        this.taxMab = taxMab;
    }

    public BigDecimal getTollMab() {
        return tollMab;
    }

    public void setTollMab(BigDecimal tollMab) {
        this.tollMab = tollMab;
    }

    public BigDecimal getTaxCoEff() {
        return taxCoEff;
    }

    public void setTaxCoEff(BigDecimal taxCoEff) {
        this.taxCoEff = taxCoEff;
    }

    public Boolean getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Boolean isPromotion) {
        this.isPromotion = isPromotion;
    }

    public BigDecimal getBaseDReferID() {
        return baseDReferID;
    }

    public void setBaseDReferID(BigDecimal baseDReferID) {
        this.baseDReferID = baseDReferID;
    }

    public BigDecimal getSecondGoodsID() {
        return secondGoodsID;
    }

    public void setSecondGoodsID(BigDecimal secondGoodsID) {
        this.secondGoodsID = secondGoodsID;
    }

    public BigDecimal getrRowMabPrice() {
        return rRowMabPrice;
    }

    public void setrRowMabPrice(BigDecimal rRowMabPrice) {
        this.rRowMabPrice = rRowMabPrice;
    }

    public BigDecimal getrRowMabPercent() {
        return rRowMabPercent;
    }

    public void setrRowMabPercent(BigDecimal rRowMabPercent) {

        this.rRowMabPercent = rRowMabPercent;
    }

    public BigDecimal getTollCoEff() {
        return tollCoEff;
    }

    public void setTollCoEff(BigDecimal tollCoEff) {
        this.tollCoEff = tollCoEff;
    }

    public BigDecimal getAnalysisNo() {
        return analysisNo;
    }

    public void setAnalysisNo(BigDecimal analysisNo) {
        this.analysisNo = analysisNo;
    }

    public StringBuilder createQuery(String parameterName) {
        Field[] fields = this.getClass().getDeclaredFields();
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("INSERT INTO @").append(parameterName).append(" VALUES(").append("\n");
        try {
            for (Field field : fields) {
                Object value = field.get(this);
                if (field.getType().equals(java.math.BigDecimal.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.lang.String.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.util.Date.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.lang.Boolean.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        sqlQuery.append(((Boolean) value).booleanValue() ? 1 : 0).append(", --").append(field.getName()).append("\n");
                    }
                } else if (field.getType().equals(java.lang.Object.class)) {
                    if (value == null) {
                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
                    } else {
                        if (value.getClass() == java.math.BigDecimal.class) {
                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.Integer.class) {
                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.String.class) {
                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.util.Date.class) {
                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
                        } else if (value.getClass() == java.lang.Boolean.class) {
                            sqlQuery.append((boolean) value ? 1 : 0).append(", --").append(field.getName()).append("\n");
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field fieldLast = fields[fields.length - 1];
        sqlQuery.delete(sqlQuery.length() - 1 - (", --" + fieldLast.getName()).length(),
                sqlQuery.length()
        );
        sqlQuery.append(" --").append(fieldLast.getName()).append("\n");
        sqlQuery.append(")").append("\n");
        return sqlQuery;
    }
}
