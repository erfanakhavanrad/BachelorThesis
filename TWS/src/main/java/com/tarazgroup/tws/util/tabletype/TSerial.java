package com.tarazgroup.tws.util.tabletype;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
//@Entity
public class TSerial extends TParams {
//    @Id
//    @Column(name = "_id", columnDefinition = "BINARY(16)")
//    private UUID _id = UUID.randomUUID();
    private String serialGoodsDesc;
    private BigDecimal serialQuantity;
    private BigDecimal refSerialGoodsID;
    private BigDecimal serialGoodsID;
    private BigDecimal baseSerialGoodsID;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;
    private String field10;
    private String rowID;
    private String iGUID;
    private BigDecimal vDID;

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

    public BigDecimal getRefSerialGoodsID() {
        return refSerialGoodsID;
    }

    public void setRefSerialGoodsID(BigDecimal refSerialGoodsID) {
        this.refSerialGoodsID = refSerialGoodsID;
    }

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

    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }

    public String getiGUID() {
        return iGUID;
    }

    public void setiGUID(String iGUID) {
        this.iGUID = iGUID;
    }

    public BigDecimal getvDID() {
        return vDID;
    }

    public void setvDID(BigDecimal vDID) {
        this.vDID = vDID;
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
