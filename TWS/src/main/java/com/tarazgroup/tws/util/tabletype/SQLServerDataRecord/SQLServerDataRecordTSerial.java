package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.TSerial;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class SQLServerDataRecordTSerial implements ISQLServerDataRecord {
    int index = -1;
    TSerial[] TSerials;

    public SQLServerDataRecordTSerial(TSerial[] tserial) {
        this.TSerials = tserial;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int i) {
        switch (i) {
            case 1:
                return new SQLServerMetaData("serialGoodsDesc", Types.VARCHAR);
            case 2:
                return new SQLServerMetaData("serialQuantity", Types.DECIMAL);
            case 3:
                return new SQLServerMetaData("refSerialGoodsID", Types.DECIMAL);
            case 4:
                return new SQLServerMetaData("serialGoodsID", Types.DECIMAL);
            case 5:
                return new SQLServerMetaData("baseSerialGoodsID", Types.DECIMAL);
            case 6:
                return new SQLServerMetaData("field1", Types.VARCHAR);
            case 7:
                return new SQLServerMetaData("field2", Types.VARCHAR);
            case 8:
                return new SQLServerMetaData("field3", Types.VARCHAR);
            case 9:
                return new SQLServerMetaData("field4", Types.VARCHAR);
            case 10:
                return new SQLServerMetaData("field5", Types.VARCHAR);
            case 11:
                return new SQLServerMetaData("field6", Types.VARCHAR);
            case 12:
                return new SQLServerMetaData("field7", Types.VARCHAR);
            case 13:
                return new SQLServerMetaData("field8", Types.VARCHAR);
            case 14:
                return new SQLServerMetaData("field9", Types.VARCHAR);
            case 15:
                return new SQLServerMetaData("field10", Types.VARCHAR);
            case 16:
                return new SQLServerMetaData("rowID", Types.VARCHAR);
            case 17:
                return new SQLServerMetaData("iGUID", Types.VARCHAR);
            case 18:
                return new SQLServerMetaData("vDID", Types.DECIMAL);
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 18;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObject = new Object[18];
        rowObject[0] = TSerials[index].getSerialGoodsDesc();
        rowObject[1] = TSerials[index].getSerialQuantity();
        rowObject[2] = TSerials[index].getRefSerialGoodsID();
        rowObject[3] = TSerials[index].getSerialGoodsID();
        rowObject[4] = TSerials[index].getBaseSerialGoodsID();
        rowObject[5] = TSerials[index].getField1();
        rowObject[6] = TSerials[index].getField2();
        rowObject[7] = TSerials[index].getField3();
        rowObject[8] = TSerials[index].getField4();
        rowObject[9] = TSerials[index].getField5();
        rowObject[10] = TSerials[index].getField6();
        rowObject[11] = TSerials[index].getField7();
        rowObject[12] = TSerials[index].getField8();
        rowObject[13] = TSerials[index].getField9();
        rowObject[14] = TSerials[index].getField10();
        rowObject[15] = TSerials[index].getRowID();
        rowObject[16] = TSerials[index].getiGUID();
        rowObject[17] = TSerials[index].getvDID();
        return rowObject;
    }

    @Override
    public boolean next() {
        index++;
        if (TSerials.length > index)
            return true;
        else
            return false;
    }
}
