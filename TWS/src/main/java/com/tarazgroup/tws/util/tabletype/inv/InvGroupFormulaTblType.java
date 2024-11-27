package com.tarazgroup.tws.util.tabletype.inv;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */
public class InvGroupFormulaTblType {

    private String fCode;

    private String fVal;

    public String getFCode() {
        return fCode;
    }

    public void setFCode(String fCode) {
        this.fCode = fCode;
    }

    public String getFVal() {
        return fVal;
    }

    public void setFVal(String fVal) {
        this.fVal = fVal;
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
