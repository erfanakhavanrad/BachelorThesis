package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
//import com.tarazgroup.tws.util.tabletype.crm.CrmFormFieldValueType;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class SQLServerDataRecordCrmFormFieldValueType implements ISQLServerDataRecord {
    int index = -1;

//    CrmFormFieldValueType[] crmFormFieldValueType;

//    public SQLServerDataRecordCrmFormFieldValueType(CrmFormFieldValueType[] crmFormFieldValueType) {
//        this.crmFormFieldValueType = crmFormFieldValueType;
//    }

    @Override
    public SQLServerMetaData getColumnMetaData(int column) {
        switch (column) {
            case 1:
                return new SQLServerMetaData("FieldID", Types.DECIMAL);
            case 2:
                return new SQLServerMetaData("FieldValue", microsoft.sql.Types.SQL_VARIANT);
            case 3:
                return new SQLServerMetaData("ValueID", Types.DECIMAL);
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObject = new Object[3];
//        rowObject[0] = crmFormFieldValueType[index].getFieldID();
//        rowObject[1] = crmFormFieldValueType[index].getFieldValue();
//        rowObject[2] = crmFormFieldValueType[index].getValueID();
        return rowObject;
    }

    @Override
    public boolean next() {
//        index++;
//        if (crmFormFieldValueType.length > index)
//            return true;
//        else
//            return false;
        return true;
    }
}
