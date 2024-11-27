package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.TElement;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class SQLServerDataRecordTElement implements ISQLServerDataRecord {
    int index = -1;
    TElement[] tElement;

    public SQLServerDataRecordTElement(TElement[] tElements) {
        this.tElement = tElements;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int i) {
        switch (i) {
            case 1:
                return new SQLServerMetaData("elementID", Types.DECIMAL);
            case 2:
                return new SQLServerMetaData("elementMab", Types.DECIMAL);
            case 3:
                return new SQLServerMetaData("voucherTypeID", Types.DECIMAL);
            case 4:
                return new SQLServerMetaData("VoucherHeaderID", Types.DECIMAL);
            case 5:
                return new SQLServerMetaData("isActive", Types.BIT);
            case 6:
                return new SQLServerMetaData("printPriority", Types.TINYINT);
            case 7:
                return new SQLServerMetaData("computePriority", Types.TINYINT);
            case 8:
                return new SQLServerMetaData("coEfficient", Types.DECIMAL);
            case 9:
                return new SQLServerMetaData("rowNo", Types.SMALLINT);
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObjects = new Object[9];
        rowObjects[0] = tElement[index].getElementID();
        rowObjects[1] = tElement[index].getElementMab();
        rowObjects[2] = tElement[index].getVoucherTypeID();
        rowObjects[3] = tElement[index].getVoucherHeaderID();
        rowObjects[4] = tElement[index].isActive();
        rowObjects[5] = tElement[index].getPrintPriority();
        rowObjects[6] = tElement[index].getComputePriority();
        rowObjects[7] = tElement[index].getCoEfficient();
        rowObjects[8] = tElement[index].getRowNo();
        return rowObjects;
    }

    @Override
    public boolean next() {
        index++;
        if (tElement.length > index)
            return true;
        else
            return false;
    }
}
