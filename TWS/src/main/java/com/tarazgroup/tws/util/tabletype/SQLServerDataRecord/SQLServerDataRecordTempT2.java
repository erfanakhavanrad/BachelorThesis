package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.TempT2;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

public class SQLServerDataRecordTempT2 implements ISQLServerDataRecord {

    int index = -1;
    TempT2[] tempT2;

    public SQLServerDataRecordTempT2(TempT2[] tempT2) {
        this.tempT2 = tempT2;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int i) {
        switch (i) {
            case 1:
                return new SQLServerMetaData("mID", Types.DECIMAL);
            case 2:
                return new SQLServerMetaData("mID2", Types.DECIMAL);
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObject = new Object[2];
        rowObject[0] = tempT2[index].getmID();
        rowObject[1] = tempT2[index].getmID2();
        return rowObject;
    }


    @Override
    public boolean next() {
        index++;
        if (tempT2.length > index)
            return true;
        else
            return false;
    }


}
