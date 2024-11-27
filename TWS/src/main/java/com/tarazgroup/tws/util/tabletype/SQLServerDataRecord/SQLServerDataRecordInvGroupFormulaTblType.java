package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class SQLServerDataRecordInvGroupFormulaTblType implements ISQLServerDataRecord {
    int index = -1;

    InvGroupFormulaTblType[] invGroupFormulaTblType;

    public SQLServerDataRecordInvGroupFormulaTblType(InvGroupFormulaTblType[] invGroupFormulaTblType) {
        this.invGroupFormulaTblType = invGroupFormulaTblType;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int i) {
        switch (i) {
            case 1:
                return new SQLServerMetaData("FCode", Types.NVARCHAR);
            case 2:
                return new SQLServerMetaData("FVal", Types.NVARCHAR);
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
        rowObject[0] = invGroupFormulaTblType[index].getFCode();
        rowObject[1] = invGroupFormulaTblType[index].getFVal();
        return rowObject;
    }

    @Override
    public boolean next() {
        index++;
        if (invGroupFormulaTblType.length > index)
            return true;
        else
            return false;
    }
}
