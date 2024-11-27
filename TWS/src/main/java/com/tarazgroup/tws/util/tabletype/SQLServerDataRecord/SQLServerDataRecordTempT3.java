package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.TempT3;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class SQLServerDataRecordTempT3 implements ISQLServerDataRecord {
    int index = -1;
    TempT3[] tempT3;

    public SQLServerDataRecordTempT3(TempT3[] tempT3) {
        this.tempT3 = tempT3;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int column) {
        switch (column) {
            case 1:
                return new SQLServerMetaData("VoucherTypeID", Types.DECIMAL);
            case 2:
                return new SQLServerMetaData("RecieptTypeID", Types.DECIMAL);
            case 3:
                return new SQLServerMetaData("ServerID", Types.DECIMAL);
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
        rowObject[0] = tempT3[index].getVoucherTypeID();
        rowObject[1] = tempT3[index].getRecieptTypeID();
        rowObject[2] = tempT3[index].getServerID();
        return rowObject;
    }

    @Override
    public boolean next() {
        index++;
        if (tempT3.length > index)
            return true;
        else
            return false;
    }
}
