package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvSerialGoodsTable;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface InvSerialGoodsTableRepository extends TCrudRepository<InvSerialGoodsTable>, CrudRepository<InvSerialGoodsTable, BigDecimal> {
    default List<InvSerialGoodsTable> invShowSerialGoodsTable(InvSerialGoodsTable invSerialGoods_table) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invSerialGoods_table._serverFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invSerialGoods_table._pageFilter()));
        return showSP("InvShowSerialGoods_Table", tParameters, true);
    }

    default InvSerialGoodsTable invShowSerialGoodsTableByID(BigDecimal serialGoodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND SerialGoodsID=" + serialGoodsID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowSerialGoods_Table", tParameters, true).get(0);

    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "serialGoodsID", "serialGoodsID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "baseSerialGoodsID", "ای دی سریال محصولات اصلی", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "serialGoodsDesc", "توضیح محصولات اصلی", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "serialQuantity", "تعداد سریال", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherDetailID", "voucherDetailID", Type.STRING, 120, false, false, false));
        cols.add(new Col(null, "field1", "فیلد ۱", Type.DATE, 100, true, true, false));
        cols.add(new Col(null, "field2", "فیلذ ۲", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "field3", "فیلد ", Type.DATE, 120, true, true, false));
        cols.add(new Col(null, "field4", "فیلد ۳", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "field5", "فیلد ۴", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "field6", "فیلد ۵", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "field7", "فیلد ۶", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "field8", "فیلد ۷", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "field9", "فیلد ۸", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "field10", "فیلد ۹", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "refSerialGoodsID", "refSerialGoodsID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "buyID", "ای دی خرید", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "saleID", "ای دی فروش", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "mppID", "mppID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "rowID", "rowID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);


    }


//    default InvSerialGoodsTable invUpdSerialGoodTable(BigDecimal serialGoodsID, InvSerialGoodsTable invSerialGoodsTable) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("SerialGoodsID", invSerialGoodsTable.getSerialGoodsID()));
//        tParameters.add(new TParameter<>("SerialGoodsDesc", invSerialGoodsTable.getSerialGoodsDesc()));
//        tParameters.add(new TParameter<>("VoucherDetailID", invSerialGoodsTable.getVoucherDetailID()));
//        tParameters.add(new TParameter<>("Field1", invSerialGoodsTable.getField1()));
//        tParameters.add(new TParameter<>("Field2", invSerialGoodsTable.getField2()));
//        tParameters.add(new TParameter<>("Field3", invSerialGoodsTable.getField3()));
//        tParameters.add(new TParameter<>("Field4", invSerialGoodsTable.getField4()));
//        tParameters.add(new TParameter<>("Field5", invSerialGoodsTable.getField5()));
//        tParameters.add(new TParameter<>("Field6", invSerialGoodsTable.getField6()));
//        tParameters.add(new TParameter<>("Field7", invSerialGoodsTable.getField7()));
//        tParameters.add(new TParameter<>("Field8", invSerialGoodsTable.getField8()));
//        tParameters.add(new TParameter<>("Field9", invSerialGoodsTable.getField9()));
//        tParameters.add(new TParameter<>("Field10", invSerialGoodsTable.getField10()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("RefSerialGoodsID", invSerialGoodsTable.getRefSerialGoodsID()));
//        tParameters.add(new TParameter<>("BaseSerialGoodsID", invSerialGoodsTable.getBaseSerialGoodsID()));
//        updSP("InvUpdSerialGoods", tParameters);
//        return invShowSerialGoodsTableByID(serialGoodsID);
//    }
//
//    default void invDelSerialGoodTable(BigDecimal serialGoodsID, InvSerialGoodsTable invSerialGoodsTable) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("SerialGoodsID", serialGoodsID));
//        tParameters.add(new TParameter<>("VoucherDetailID", invSerialGoodsTable.getVoucherDetailID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        delSP("InvDelSerialGoods", tParameters);
//    }

}
