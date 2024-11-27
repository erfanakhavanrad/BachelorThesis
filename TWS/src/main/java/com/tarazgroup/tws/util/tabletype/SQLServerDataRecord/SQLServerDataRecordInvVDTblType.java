package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.inv.InvVDTblType;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class SQLServerDataRecordInvVDTblType implements ISQLServerDataRecord {
    int index = -1;
    InvVDTblType[] invVDTblTypes;

    public SQLServerDataRecordInvVDTblType(InvVDTblType[] invVDTblTypes) {
        this.invVDTblTypes = invVDTblTypes;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int i) {
        switch (i) {
            case 1:
                return new SQLServerMetaData("RowNo", Types.DECIMAL);
            case 2:
                return new SQLServerMetaData("VoucherDetailID", Types.DECIMAL);
            case 3:
                return new SQLServerMetaData("VoucherHeaderID", Types.DECIMAL);
            case 4:
                return new SQLServerMetaData("GoodsID", Types.DECIMAL);
            case 5:
                return new SQLServerMetaData("SecUnitID", Types.DECIMAL);
            case 6:
                return new SQLServerMetaData("Quantity", Types.DECIMAL);
            case 7:
                return new SQLServerMetaData("Fee", Types.DECIMAL);
            case 8:
                return new SQLServerMetaData("DetailXDesc", Types.NVARCHAR);
            case 9:
                return new SQLServerMetaData("DReferID", Types.DECIMAL);
            case 10:
                return new SQLServerMetaData("CreatorID", Types.DECIMAL);
            case 11:
                return new SQLServerMetaData("ModifierID", Types.DECIMAL);
            case 12:
                return new SQLServerMetaData("DifferentialID", Types.DECIMAL);
            case 13:
                return new SQLServerMetaData("AnalysisSetup", Types.BIT);
            case 14:
                return new SQLServerMetaData("ComputeValue", Types.DECIMAL);
            case 15:
                return new SQLServerMetaData("CustomField1", Types.NVARCHAR);
            case 16:
                return new SQLServerMetaData("CustomField2", Types.NVARCHAR);
            case 17:
                return new SQLServerMetaData("CustomField3", Types.NVARCHAR);
            case 18:
                return new SQLServerMetaData("CustomField4", Types.NVARCHAR);
            case 19:
                return new SQLServerMetaData("CustomField5", Types.NVARCHAR);
            case 20:
                return new SQLServerMetaData("CustomField6", Types.NVARCHAR);
            case 21:
                return new SQLServerMetaData("CustomField7", Types.NVARCHAR);
            case 22:
                return new SQLServerMetaData("CustomField8", Types.NVARCHAR);
            case 23:
                return new SQLServerMetaData("CustomField9", Types.NVARCHAR);
            case 24:
                return new SQLServerMetaData("CustomField10", Types.NVARCHAR);
            case 25:
                return new SQLServerMetaData("CustomField11", Types.DECIMAL);
            case 26:
                return new SQLServerMetaData("FeeFrieghtCharges", Types.DECIMAL);
            case 27:
                return new SQLServerMetaData("LCReferID", Types.DECIMAL);
            case 28:
                return new SQLServerMetaData("AgrReferID", Types.DECIMAL);
            case 29:
                return new SQLServerMetaData("Quantity2", Types.DECIMAL);
            case 30:
                return new SQLServerMetaData("Quantity3", Types.DECIMAL);
            case 31:
                return new SQLServerMetaData("SecUnitID2", Types.DECIMAL);
            case 32:
                return new SQLServerMetaData("SecUnitID3", Types.DECIMAL);
            case 33:
                return new SQLServerMetaData("CustomField12", Types.NVARCHAR);
            case 34:
                return new SQLServerMetaData("CustomField13", Types.NVARCHAR);
            case 35:
                return new SQLServerMetaData("CustomField14", Types.NVARCHAR);
            case 36:
                return new SQLServerMetaData("CustomField15", Types.NVARCHAR);
            case 37:
                return new SQLServerMetaData("CustomField16", Types.NVARCHAR);
            case 38:
                return new SQLServerMetaData("CustomField17", Types.NVARCHAR);
            case 39:
                return new SQLServerMetaData("CustomField18", Types.NVARCHAR);
            case 40:
                return new SQLServerMetaData("CustomField19", Types.NVARCHAR);
            case 41:
                return new SQLServerMetaData("CustomField20", Types.NVARCHAR);
            case 42:
                return new SQLServerMetaData("CustomField21", Types.NVARCHAR);
            case 43:
                return new SQLServerMetaData("CustomField22", Types.NVARCHAR);
            case 44:
                return new SQLServerMetaData("CustomField23", Types.NVARCHAR);
            case 45:
                return new SQLServerMetaData("CustomField24", Types.NVARCHAR);
            case 46:
                return new SQLServerMetaData("CustomField25", Types.NVARCHAR);
            case 47:
                return new SQLServerMetaData("FeeAgreement", Types.DECIMAL);
            case 48:
                return new SQLServerMetaData("FeeDiscountPrice", Types.DECIMAL);
            case 49:
                return new SQLServerMetaData("FeeDiscountPercent", Types.DECIMAL);
            case 50:
                return new SQLServerMetaData("StoreID", Types.DECIMAL);
            case 51:
                return new SQLServerMetaData("Center1ID", Types.DECIMAL);
            case 52:
                return new SQLServerMetaData("Center2ID", Types.DECIMAL);
            case 53:
                return new SQLServerMetaData("Center3ID", Types.DECIMAL);
            case 54:
                return new SQLServerMetaData("iGUID", Types.NVARCHAR);
            case 55:
                return new SQLServerMetaData("BaseFee", Types.DECIMAL);
            case 56:
                return new SQLServerMetaData("AnalysisNo", Types.DECIMAL);
            case 57:
                return new SQLServerMetaData("BaseDReferId", Types.DECIMAL);
            case 58:
                return new SQLServerMetaData("AnalysisNos", Types.NVARCHAR);

        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 58;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObject = new Object[58];
        rowObject[0] = invVDTblTypes[index].getRowNo();
        rowObject[1] = invVDTblTypes[index].getVoucherDetailID();
        rowObject[2] = invVDTblTypes[index].getVoucherHeaderID();
        rowObject[3] = invVDTblTypes[index].getGoodsID();
        rowObject[4] = invVDTblTypes[index].getSecUnitID();
        rowObject[5] = invVDTblTypes[index].getQuantity();
        rowObject[6] = invVDTblTypes[index].getFee();
        rowObject[7] = invVDTblTypes[index].getDetailXDesc();
        rowObject[8] = invVDTblTypes[index].getDReferID();
        rowObject[9] = invVDTblTypes[index].getCreatorID();
        rowObject[10] = invVDTblTypes[index].getModifierID();

        rowObject[11] = invVDTblTypes[index].getDifferentialID();
        rowObject[12] = invVDTblTypes[index].getAnalysisSetup();
        rowObject[13] = invVDTblTypes[index].getComputeValue();
        rowObject[14] = invVDTblTypes[index].getCustomField1();
        rowObject[15] = invVDTblTypes[index].getCustomField2();
        rowObject[16] = invVDTblTypes[index].getCustomField3();
        rowObject[17] = invVDTblTypes[index].getCustomField4();
        rowObject[18] = invVDTblTypes[index].getCustomField5();
        rowObject[19] = invVDTblTypes[index].getCustomField6();
        rowObject[20] = invVDTblTypes[index].getCustomField7();
        rowObject[21] = invVDTblTypes[index].getCustomField8();

        rowObject[22] = invVDTblTypes[index].getCustomField9();
        rowObject[23] = invVDTblTypes[index].getCustomField10();
        rowObject[24] = invVDTblTypes[index].getCustomField11();
        rowObject[25] = invVDTblTypes[index].getFeeFrieghtCharges();
        rowObject[26] = invVDTblTypes[index].getLCReferID();

        rowObject[27] = invVDTblTypes[index].getAgrReferID();
        rowObject[28] = invVDTblTypes[index].getQuantity2();
        rowObject[29] = invVDTblTypes[index].getQuantity3();
        rowObject[30] = invVDTblTypes[index].getSecUnitID2();
        rowObject[31] = invVDTblTypes[index].getSecUnitID3();
        rowObject[32] = invVDTblTypes[index].getCustomField12();
        rowObject[33] = invVDTblTypes[index].getCustomField13();
        rowObject[34] = invVDTblTypes[index].getCustomField14();
        rowObject[35] = invVDTblTypes[index].getCustomField15();
        rowObject[36] = invVDTblTypes[index].getCustomField16();

        rowObject[37] = invVDTblTypes[index].getCustomField17();
        rowObject[38] = invVDTblTypes[index].getCustomField18();
        rowObject[39] = invVDTblTypes[index].getCustomField19();
        rowObject[40] = invVDTblTypes[index].getCustomField20();
        rowObject[41] = invVDTblTypes[index].getCustomField21();
        rowObject[42] = invVDTblTypes[index].getCustomField22();
        rowObject[43] = invVDTblTypes[index].getCustomField23();
        rowObject[44] = invVDTblTypes[index].getCustomField24();
        rowObject[45] = invVDTblTypes[index].getCustomField25();
        rowObject[46] = invVDTblTypes[index].getFeeAgreement();
        rowObject[47] = invVDTblTypes[index].getFeeDiscountPrice();
        rowObject[48] = invVDTblTypes[index].getFeeDiscountPercent();
        rowObject[49] = invVDTblTypes[index].getStoreID();

        rowObject[50] = invVDTblTypes[index].getCenter1ID();
        rowObject[51] = invVDTblTypes[index].getCenter2ID();
        rowObject[52] = invVDTblTypes[index].getCenter3ID();
        rowObject[53] = invVDTblTypes[index].getiGUID();
        rowObject[54] = invVDTblTypes[index].getBaseFee();
        rowObject[55] = invVDTblTypes[index].getAnalysisNo();
        rowObject[56] = invVDTblTypes[index].getBaseDReferId();
        rowObject[57] = invVDTblTypes[index].getAnalysisNos();

        return rowObject;
    }

    @Override
    public boolean next() {
        index++;
        if (invVDTblTypes.length > index)
            return true;
        else
            return false;
    }
}
