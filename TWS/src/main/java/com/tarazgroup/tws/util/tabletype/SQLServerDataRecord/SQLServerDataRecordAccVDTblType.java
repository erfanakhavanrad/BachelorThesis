package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.acc.AccVDTblType;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class SQLServerDataRecordAccVDTblType implements ISQLServerDataRecord {
    int index = -1;
    AccVDTblType[] accVDTblType;

    public SQLServerDataRecordAccVDTblType(AccVDTblType[] accVDTblType) {
        this.accVDTblType = accVDTblType;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int column) {
        switch (column) {
            case 1:
                return new SQLServerMetaData("VoucherDetailID", Types.DECIMAL);
            case 2:
                return new SQLServerMetaData("AccountID", Types.DECIMAL);
            case 3:
                return new SQLServerMetaData("TafsiliID", Types.DECIMAL);
            case 4:
                return new SQLServerMetaData("Center1ID", Types.DECIMAL);
            case 5:
                return new SQLServerMetaData("Center2ID", Types.DECIMAL);
            case 6:
                return new SQLServerMetaData("Center3ID", Types.DECIMAL);
            case 7:
                return new SQLServerMetaData("Bed", Types.DECIMAL);
            case 8:
                return new SQLServerMetaData("Bes", Types.DECIMAL);
            case 9:
                return new SQLServerMetaData("DetailXDesc", Types.NVARCHAR);
            case 10:
                return new SQLServerMetaData("CurrencyID", Types.DECIMAL);
            case 11:
                return new SQLServerMetaData("CurrencyCount", Types.DECIMAL);
            case 12:
                return new SQLServerMetaData("DocCount", Types.DECIMAL);
            case 13:
                return new SQLServerMetaData("DocNum", Types.NVARCHAR);
            case 14:
                return new SQLServerMetaData("DocDate", Types.CHAR);
            case 15:
                return new SQLServerMetaData("RowNo", Types.DECIMAL);
            case 16:
                return new SQLServerMetaData("ReferID", Types.DECIMAL);
            case 17:
                return new SQLServerMetaData("RefTypeID", Types.DECIMAL);
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 17;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObject = new Object[17];
        rowObject[0] = accVDTblType[index].getVoucherDetailID();
        rowObject[1] = accVDTblType[index].getAccountID();
        rowObject[2] = accVDTblType[index].getTafsiliID();
        rowObject[3] = accVDTblType[index].getCenter1ID();
        rowObject[4] = accVDTblType[index].getCenter2ID();
        rowObject[5] = accVDTblType[index].getCenter3ID();
        rowObject[6] = accVDTblType[index].getBed();
        rowObject[7] = accVDTblType[index].getBes();
        rowObject[8] = accVDTblType[index].getDetailXDesc();
        rowObject[9] = accVDTblType[index].getCurrencyID();
        rowObject[10] = accVDTblType[index].getCurrencyCount();
        rowObject[11] = accVDTblType[index].getDocCount();
        rowObject[12] = accVDTblType[index].getDocNum();
        rowObject[13] = accVDTblType[index].getDocDate();
        rowObject[14] = accVDTblType[index].getRowNo();
        rowObject[15] = accVDTblType[index].getReferID();
        rowObject[16] = accVDTblType[index].getRefTypeID();
        return rowObject;
    }

    @Override
    public boolean next() {
        index++;
        if (accVDTblType.length > index)
            return true;
        else
            return false;
    }
}
