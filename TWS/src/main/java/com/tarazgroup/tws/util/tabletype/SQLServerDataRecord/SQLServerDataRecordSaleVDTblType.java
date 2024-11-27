package com.tarazgroup.tws.util.tabletype.SQLServerDataRecord;

import com.microsoft.sqlserver.jdbc.ISQLServerDataRecord;
import com.microsoft.sqlserver.jdbc.SQLServerMetaData;
import com.tarazgroup.tws.util.tabletype.sale.SaleVDTblType;

import java.sql.Types;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class SQLServerDataRecordSaleVDTblType implements ISQLServerDataRecord {
    int index = -1;
    SaleVDTblType[] saleVDTblTypes;

    public SQLServerDataRecordSaleVDTblType(SaleVDTblType[] saleVDTblTypes){
       this.saleVDTblTypes = saleVDTblTypes;
    }

    @Override
    public SQLServerMetaData getColumnMetaData(int i) {
        switch (i){
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
                return new SQLServerMetaData("ComputeValue", Types.DECIMAL);
            case 14:
                return new SQLServerMetaData("CustomField1", Types.NVARCHAR);
            case 15:
                return new SQLServerMetaData("CustomField2", Types.NVARCHAR);
            case 16:
                return new SQLServerMetaData("CustomField3", Types.NVARCHAR);
            case 17:
                return new SQLServerMetaData("CustomField4", Types.NVARCHAR);
            case 18:
                return new SQLServerMetaData("CustomField5", Types.NVARCHAR);
            case 19:
                return new SQLServerMetaData("CustomField6", Types.NVARCHAR);
            case 20:
                return new SQLServerMetaData("CustomField7", Types.NVARCHAR);
            case 21:
                return new SQLServerMetaData("CustomField8", Types.NVARCHAR);
            case 22:
                return new SQLServerMetaData("CustomField9", Types.NVARCHAR);
            case 23:
                return new SQLServerMetaData("CustomField10", Types.NVARCHAR);
            case 24:
                return new SQLServerMetaData("CustomField11", Types.DECIMAL);
            case 25:
                return new SQLServerMetaData("FeeAgreement", Types.DECIMAL);
            case 26:
                return new SQLServerMetaData("FeeDiscountPrice", Types.DECIMAL);
            case 27:
                return new SQLServerMetaData("FeeDiscountPercent", Types.DECIMAL);
            case 28:
                return new SQLServerMetaData("FeeFrieghtCharges", Types.DECIMAL);
            case 29:
                return new SQLServerMetaData("AllocatedQuantity2", Types.DECIMAL);
            case 30:
                return new SQLServerMetaData("OverAllocatedQuantity2", Types.DECIMAL);
            case 31:
                return new SQLServerMetaData("LCReferID", Types.DECIMAL);
            case 32:
                return new SQLServerMetaData("AgrReferID", Types.DECIMAL);
            case 33:
                return new SQLServerMetaData("Quantity2", Types.DECIMAL);
            case 34:
                return new SQLServerMetaData("Quantity3", Types.DECIMAL);
            case 35:
                return new SQLServerMetaData("SecUnitID2", Types.DECIMAL);
            case 36:
                return new SQLServerMetaData("SecUnitID3", Types.DECIMAL);
            case 37:
                return new SQLServerMetaData("CustomField12", Types.NVARCHAR);
            case 38:
                return new SQLServerMetaData("CustomField13", Types.NVARCHAR);
            case 39:
                return new SQLServerMetaData("CustomField14", Types.NVARCHAR);
            case 40:
                return new SQLServerMetaData("CustomField15", Types.NVARCHAR);
            case 41:
                return new SQLServerMetaData("CustomField16", Types.NVARCHAR);
            case 42:
                return new SQLServerMetaData("CustomField17", Types.NVARCHAR);
            case 43:
                return new SQLServerMetaData("CustomField18", Types.NVARCHAR);
            case 44:
                return new SQLServerMetaData("CustomField19", Types.NVARCHAR);
            case 45:
                return new SQLServerMetaData("CustomField20", Types.NVARCHAR);
            case 46:
                return new SQLServerMetaData("CustomField21", Types.NVARCHAR);
            case 47:
                return new SQLServerMetaData("CustomField22", Types.NVARCHAR);
            case 48:
                return new SQLServerMetaData("CustomField23", Types.NVARCHAR);
            case 49:
                return new SQLServerMetaData("CustomField24", Types.NVARCHAR);
            case 50:
                return new SQLServerMetaData("CustomField25", Types.NVARCHAR);
            case 51:
                return new SQLServerMetaData("StoreID", Types.DECIMAL);
            case 52:
                return new SQLServerMetaData("Center1ID", Types.DECIMAL);
            case 53:
                return new SQLServerMetaData("Center2ID", Types.DECIMAL);
            case 54:
                return new SQLServerMetaData("Center3ID", Types.DECIMAL);
            case 55:
                return new SQLServerMetaData("iGUID", Types.NVARCHAR);
            case 56:
                return new SQLServerMetaData("TaxMab", Types.DECIMAL);
            case 57:
                return new SQLServerMetaData("TollMab", Types.DECIMAL);
            case 58:
                return new SQLServerMetaData("TaxCoEff", Types.DECIMAL);
            case 59:
                return new SQLServerMetaData("IsPromotion", Types.BIT);
            case 60:
                return new SQLServerMetaData("BaseDReferID", Types.DECIMAL);
            case 61:
                return new SQLServerMetaData("SecondGoodsID", Types.DECIMAL);
            case 62:
                return new SQLServerMetaData("RRowMabPrice", Types.DECIMAL);
            case 63:
                return new SQLServerMetaData("RRowMabPercent", Types.DECIMAL);
            case 64:
                return new SQLServerMetaData("TollCoEff", Types.DECIMAL);

        }
        return null;
    }

    @Override
    public int getColumnCount() {
        return 64;
    }

    @Override
    public Object[] getRowData() {
        Object[] rowObject = new Object[64];
        rowObject[0] = saleVDTblTypes[index].getRowNo();
        rowObject[1] = saleVDTblTypes[index].getVoucherDetailID();
        rowObject[2] = saleVDTblTypes[index].getVoucherHeaderID();
        rowObject[3] = saleVDTblTypes[index].getGoodsID();
        rowObject[4] = saleVDTblTypes[index].getSecUnitID();
        rowObject[5] = saleVDTblTypes[index].getQuantity();
        rowObject[6] = saleVDTblTypes[index].getFee();
        rowObject[7] = saleVDTblTypes[index].getDetailXDesc();
        rowObject[8] = saleVDTblTypes[index].getdReferID();
        rowObject[9] = saleVDTblTypes[index].getCreatorID();
        rowObject[10] = saleVDTblTypes[index].getModifierID();

        rowObject[11] = saleVDTblTypes[index].getDifferentialID();
        rowObject[12] = saleVDTblTypes[index].getComputeValue();
        rowObject[13] = saleVDTblTypes[index].getCustomField1();
        rowObject[14] = saleVDTblTypes[index].getCustomField2();
        rowObject[15] = saleVDTblTypes[index].getCustomField3();
        rowObject[16] = saleVDTblTypes[index].getCustomField4();
        rowObject[17] = saleVDTblTypes[index].getCustomField5();
        rowObject[18] = saleVDTblTypes[index].getCustomField6();
        rowObject[19] = saleVDTblTypes[index].getCustomField7();
        rowObject[20] = saleVDTblTypes[index].getCustomField8();

        rowObject[21] = saleVDTblTypes[index].getCustomField9();
        rowObject[22] = saleVDTblTypes[index].getCustomField10();
        rowObject[23] = saleVDTblTypes[index].getCustomField11();
        rowObject[24] = saleVDTblTypes[index].getFeeAgreement();
        rowObject[25] = saleVDTblTypes[index].getFeeDiscountPrice();
        rowObject[26] = saleVDTblTypes[index].getFeeDiscountPercent();
        rowObject[27] = saleVDTblTypes[index].getFeeFrieghtCharges();
        rowObject[28] = saleVDTblTypes[index].getAllocatedQuantity2();
        rowObject[29] = saleVDTblTypes[index].getOverAllocatedQuantity2();
        rowObject[30] = saleVDTblTypes[index].getlCReferID();

        rowObject[31] = saleVDTblTypes[index].getAgrReferID();
        rowObject[32] = saleVDTblTypes[index].getQuantity2();
        rowObject[33] = saleVDTblTypes[index].getQuantity3();
        rowObject[34] = saleVDTblTypes[index].getSecUnitID2();
        rowObject[35] = saleVDTblTypes[index].getSecUnitID3();
        rowObject[36] = saleVDTblTypes[index].getCustomField12();
        rowObject[37] = saleVDTblTypes[index].getCustomField13();
        rowObject[38] = saleVDTblTypes[index].getCustomField14();
        rowObject[39] = saleVDTblTypes[index].getCustomField15();
        rowObject[40] = saleVDTblTypes[index].getCustomField16();

        rowObject[41] = saleVDTblTypes[index].getCustomField17();
        rowObject[42] = saleVDTblTypes[index].getCustomField18();
        rowObject[43] = saleVDTblTypes[index].getCustomField19();
        rowObject[44] = saleVDTblTypes[index].getCustomField20();
        rowObject[45] = saleVDTblTypes[index].getCustomField21();
        rowObject[46] = saleVDTblTypes[index].getCustomField22();
        rowObject[47] = saleVDTblTypes[index].getCustomField23();
        rowObject[48] = saleVDTblTypes[index].getCustomField24();
        rowObject[49] = saleVDTblTypes[index].getCustomField25();
        rowObject[50] = saleVDTblTypes[index].getStoreID();

        rowObject[51] = saleVDTblTypes[index].getCenter1ID();
        rowObject[52] = saleVDTblTypes[index].getCenter2ID();
        rowObject[53] = saleVDTblTypes[index].getCenter3ID();
        rowObject[54] = saleVDTblTypes[index].getiGUID();
        rowObject[55] = saleVDTblTypes[index].getTaxMab();
        rowObject[56] = saleVDTblTypes[index].getTollMab();
        rowObject[57] = saleVDTblTypes[index].getTaxCoEff();
        rowObject[58] = saleVDTblTypes[index].getIsPromotion();
        rowObject[59] = saleVDTblTypes[index].getBaseDReferID();
        rowObject[60] = saleVDTblTypes[index].getSecondGoodsID();

        rowObject[61] = saleVDTblTypes[index].getrRowMabPrice();
        rowObject[62] = saleVDTblTypes[index].getrRowMabPercent();
        rowObject[63] = saleVDTblTypes[index].getTollCoEff();
        return  rowObject;
    }

    @Override
    public boolean next() {
        index++;
        if (saleVDTblTypes.length > index)
            return true;
        else
            return false;
    }
}
