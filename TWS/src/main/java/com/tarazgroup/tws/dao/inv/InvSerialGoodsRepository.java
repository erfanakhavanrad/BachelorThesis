package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvSerialGoods;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvSerialGoodsRepository extends CrudRepository<InvSerialGoods, BigDecimal>, TCrudRepository<InvSerialGoods> {

    default List<InvSerialGoods> invSelectSerialGoods(
            BigDecimal goodsID,
            BigDecimal voucherTypeID,
            BigDecimal refTypeID,
            BigDecimal dReferID,
            BigDecimal baseDReferID
    ) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", ""));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        parameters.add(new TParameter<>("RefTypeid", refTypeID));
        parameters.add(new TParameter<>("DReferID", null));// آی دی هدر سندی که قراره مرجع شه
        parameters.add(new TParameter<>("GoodsID", goodsID));
        parameters.add(new TParameter<>("RemainFilter", null));
        parameters.add(new TParameter<>("BaseDReferID", null));// آی دی هدر سندی که قراره مرجع شه
        parameters.add(new TParameter<>("BaseRefTypeID", null));
        return showSP("InvSelectSerialGoods", parameters, true);
    }

    default InvSerialGoods invSelectSerialGoodsByID(BigDecimal serialGoodsID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.SerialGoodsID = " + serialGoodsID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("VoucherTypeID", null));
        parameters.add(new TParameter<>("RefTypeid", null));
        parameters.add(new TParameter<>("DReferID", null));
        parameters.add(new TParameter<>("GoodsID", null));
        parameters.add(new TParameter<>("RemainFilter", null));
        parameters.add(new TParameter<>("BaseDReferID", null));
        parameters.add(new TParameter<>("BaseRefTypeID", null));
        return showSP("InvSelectSerialGoods", parameters, true).get(0);
    }

    default void invDelSerialGoods(BigDecimal serialGoodsID, BigDecimal voucherDetailID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("SerialGoodsID", serialGoodsID));
        parameters.add(new TParameter<>("VoucherDetailID", voucherDetailID));
        parameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelSerialGoods", parameters);
    }

    default InvSerialGoods invUpdSerialGoods(BigDecimal serialGoodsID, InvSerialGoods invSerialGoods) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("SerialGoodsID", serialGoodsID));
        parameters.add(new TParameter<>("SerialGoodsDesc", invSerialGoods.getSerialGoodsDesc()));
        parameters.add(new TParameter<>("SerialQuantity", invSerialGoods.getSerialQuantity()));
        parameters.add(new TParameter<>("VoucherDetailID", invSerialGoods.getVoucherDetailID()));
        parameters.add(new TParameter<>("Field1", invSerialGoods.getField1()));
        parameters.add(new TParameter<>("Field2", invSerialGoods.getField2()));
        parameters.add(new TParameter<>("Field3", invSerialGoods.getField3()));
        parameters.add(new TParameter<>("Field4", invSerialGoods.getField4()));
        parameters.add(new TParameter<>("Field5", invSerialGoods.getField5()));
        parameters.add(new TParameter<>("Field6", invSerialGoods.getField6()));
        parameters.add(new TParameter<>("Field7", invSerialGoods.getField7()));
        parameters.add(new TParameter<>("Field8", invSerialGoods.getField8()));
        parameters.add(new TParameter<>("Field9", invSerialGoods.getField9()));
        parameters.add(new TParameter<>("Field10", invSerialGoods.getField10()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getModifierID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("RefSerialGoodsID", invSerialGoods.getRefSerialGoodsID()));
        parameters.add(new TParameter<>("BaseSerialGoodsID", invSerialGoods.getBaseSerialGoodsID()));
        updSP("InvUpdSerialGoods", parameters);
        return invSelectSerialGoodsByID(serialGoodsID);
    }
}
