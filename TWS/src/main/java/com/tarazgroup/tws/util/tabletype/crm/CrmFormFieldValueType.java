package com.tarazgroup.tws.util.tabletype.crm;

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
//public class CrmFormFieldValueType {
//    private BigDecimal fieldID;
//
//    private Object fieldValue;
//
//    private BigDecimal valueID;
//
//    public BigDecimal getFieldID() {
//        return fieldID;
//    }
//
//    public void setFieldID(BigDecimal fieldID) {
//        this.fieldID = fieldID;
//    }
//
//    public Object getFieldValue() {
//        return fieldValue;
//    }
//
//    public void setFieldValue(Object fieldValue) {
//        this.fieldValue = fieldValue;
//    }
//
//    public BigDecimal getValueID() {
//        return valueID;
//    }
//
//    public void setValueID(BigDecimal valueID) {
//        this.valueID = valueID;
//    }
//
//    public StringBuilder createQuery(String parameterName) {
//        Field[] fields = this.getClass().getDeclaredFields();
//        StringBuilder sqlQuery = new StringBuilder();
//        sqlQuery.append("INSERT INTO @").append(parameterName).append(" VALUES(").append("\n");
//        try {
//            for (Field field : fields) {
//                Object value = field.get(this);
//                if (field.getType().equals(java.math.BigDecimal.class)) {
//                    if (value == null) {
//                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
//                    } else {
//                        sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
//                    }
//                } else if (field.getType().equals(java.lang.String.class)) {
//                    if (value == null) {
//                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
//                    } else {
//                        sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
//                    }
//                } else if (field.getType().equals(java.util.Date.class)) {
//                    if (value == null) {
//                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
//                    } else {
//                        sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
//                    }
//                } else if (field.getType().equals(java.lang.Boolean.class)) {
//                    if (value == null) {
//                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
//                    } else {
//                        sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
//                    }
//                } else if (field.getType().equals(java.lang.Object.class)) {
//                    if (value == null) {
//                        sqlQuery.append("NULL").append(", --").append(field.getName()).append("\n");
//                    } else {
//                        if (value.getClass() == java.math.BigDecimal.class) {
//                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
//                        } else if (value.getClass() == java.lang.Integer.class) {
//                            sqlQuery.append(value).append(", --").append(field.getName()).append("\n");
//                        } else if (value.getClass() == java.lang.String.class) {
//                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
//                        } else if (value.getClass() == java.util.Date.class) {
//                            sqlQuery.append("'").append(value).append("'").append(", --").append(field.getName()).append("\n");
//                        } else if (value.getClass() == java.lang.Boolean.class) {
//                            sqlQuery.append((boolean) value ? 1 : 0).append(", --").append(field.getName()).append("\n");
//                        }
//                    }
//                }
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Field fieldLast = fields[fields.length - 1];
//        sqlQuery.delete(sqlQuery.length() - 1 - (", --" + fieldLast.getName()).length(),
//                sqlQuery.length()
//        );
//        sqlQuery.append(" --").append(fieldLast.getName()).append("\n");
//        sqlQuery.append(")").append("\n");
//        return sqlQuery;
//    }
//}
