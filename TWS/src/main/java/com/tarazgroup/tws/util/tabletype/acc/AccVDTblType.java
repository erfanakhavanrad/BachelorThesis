package com.tarazgroup.tws.util.tabletype.acc;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class AccVDTblType {
    private BigDecimal voucherDetailID;
    private BigDecimal accountID;
    private BigDecimal tafsiliID;
    private BigDecimal center1ID;
    private BigDecimal center2ID;
    private BigDecimal center3ID;
    private BigDecimal bes;
    private BigDecimal bed;
    private String detailXDesc;
    private BigDecimal CurrencyID;
    private BigDecimal CurrencyCount;
    private BigDecimal docCount;
    private String docNum;
    private String docDate;
    private BigDecimal rowNo;
    private BigDecimal referID;
    private BigDecimal refTypeID;

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
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

    public BigDecimal getBes() {
        return bes;
    }

    public void setBes(BigDecimal bes) {
        this.bes = bes;
    }

    public BigDecimal getBed() {
        return bed;
    }

    public void setBed(BigDecimal bed) {
        this.bed = bed;
    }

    public void setCenter3ID(BigDecimal center3ID) {
        this.center3ID = center3ID;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public BigDecimal getCurrencyID() {
        return CurrencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        CurrencyID = currencyID;
    }

    public BigDecimal getCurrencyCount() {
        return CurrencyCount;
    }

    public void setCurrencyCount(BigDecimal currencyCount) {
        CurrencyCount = currencyCount;
    }

    public BigDecimal getDocCount() {
        return docCount;
    }

    public void setDocCount(BigDecimal docCount) {
        this.docCount = docCount;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
    }

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
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
                        sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
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
