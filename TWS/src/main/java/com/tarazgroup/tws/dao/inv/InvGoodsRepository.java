/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGoods;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvGoodsRepository extends TCrudRepository<InvGoods>, CrudRepository<InvGoods, BigDecimal> {

    default List<InvGoods> invShowGoods(InvGoods invGoods) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PeriodID", null));
        parameters.add(new TParameter<>("IsPrimary", null));
        parameters.add(new TParameter<>("IsDiff", null));
        parameters.add(new TParameter<>("StoreID", null));
        parameters.add(new TParameter<>("IsOrderPoint", null));
        parameters.add(new TParameter<>("IsSerial", null));
        parameters.add(new TParameter<>("PageFilter", invGoods._pageFilter()));
        return showSP("InvShowGoods", parameters, true);
    }

    default InvGoods invShowGoodsByID(BigDecimal GoodsID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.GoodsID=" + GoodsID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PeriodID", null));
        parameters.add(new TParameter<>("IsPrimary", null));
        parameters.add(new TParameter<>("IsDiff", null));
        parameters.add(new TParameter<>("StoreID", null));
        parameters.add(new TParameter<>("IsOrderPoint", null));
        parameters.add(new TParameter<>("IsSerial", null));
        parameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowGoods", parameters, true).get(0);
    }

    default InvGoods invInsGoods(InvGoods invGoods, BigDecimal goodsPositionID, BigDecimal webUserType) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("GoodsCode", invGoods.getGoodsCode()));
        parameters.add(new TParameter<>("GoodsDesc", invGoods.getGoodsDesc()));
        parameters.add(new TParameter<>("UnitID", invGoods.getUnitID()));
        parameters.add(new TParameter<>("GroupID", invGoods.getGroupID()));
        parameters.add(new TParameter<>("TypeID", invGoods.getTypeID()));
        parameters.add(new TParameter<>("TechInfo", invGoods.getTechInfo()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("CreatorID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("TafsiliTypeID", invGoods.getTafsiliTypeID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("LatinDesc", invGoods.getLatinDesc()));
        parameters.add(new TParameter<>("MinQuantity", invGoods.getMinQuantity()));
        parameters.add(new TParameter<>("MaxQuantity", invGoods.getMaxQuantity()));
        parameters.add(new TParameter<>("OrderPoint", invGoods.getOrderPoint()));
        parameters.add(new TParameter<>("OrderCount", invGoods.getOrderCount()));
        parameters.add(new TParameter<>("GoodIdentity", invGoods.getGoodIdentity()));
        parameters.add(new TParameter<>("GSerialCode", invGoods.getgSerialCode()));
        parameters.add(new TParameter<>("ImageGoods", null));
        parameters.add(new TParameter<>("GoodsBriefName", invGoods.getGoodsBriefName()));
        parameters.add(new TParameter<>("CustomTarrifNo", invGoods.getCustomTarrifNo()));
        parameters.add(new TParameter<>("IsBasket", invGoods.getIsBasket()));
        parameters.add(new TParameter<>("SecGoodsCode", invGoods.getSecGoodsCode()));
        parameters.add(new TParameter<>("BarCode", invGoods.getBarCode()));
        parameters.add(new TParameter<>("BaseFee", invGoods.getBaseFee()));
        parameters.add(new TParameter<>("OrderPick", invGoods.getOrderPick()));
        parameters.add(new TParameter<>("PricingMethod", invGoods.getPricingMethod()));
        parameters.add(new TParameter<>("GoodsPositionID", goodsPositionID));
        parameters.add(new TParameter<>("GoodsDiscountPercent", invGoods.getGoodsDiscountPercent()));
        parameters.add(new TParameter<>("GoodsDiscountPrice", invGoods.getGoodsDiscountPrice()));
        parameters.add(new TParameter<>("WebUserType", webUserType));
        parameters.add(new TParameter<>("IsNotActive", invGoods.getIsNotActive()));
        BigDecimal newID = insSP("InvInsGoods", parameters);
        return invShowGoodsByID(newID);
    }

    default void invDelGoods(BigDecimal GoodsID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        parameters.add(new TParameter<>("GoodsID", GoodsID));
        parameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        parameters.add(new TParameter<>("WebUserType",));
        delSP("InvDelGoods", parameters);
    }

    default InvGoods invUpdGoods(InvGoods invGoods, BigDecimal goodsID) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("GoodsID", goodsID));
        parameters.add(new TParameter<>("GoodsCode", invGoods.getGoodsCode()));
        parameters.add(new TParameter<>("GoodsDesc", invGoods.getGoodsDesc()));
        parameters.add(new TParameter<>("UnitID", invGoods.getUnitID()));
        parameters.add(new TParameter<>("GroupID", invGoods.getGroupID()));
        parameters.add(new TParameter<>("TypeID", invGoods.getTypeID()));
        parameters.add(new TParameter<>("TechInfo", invGoods.getTechInfo()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getModifierID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("TafsiliTypeID", invGoods.getTafsiliTypeID()));
        parameters.add(new TParameter<>("LatinDesc", invGoods.getLatinDesc()));
        parameters.add(new TParameter<>("MinQuantity", invGoods.getMinQuantity()));
        parameters.add(new TParameter<>("MaxQuantity", invGoods.getMaxQuantity()));
        parameters.add(new TParameter<>("OrderPoint", invGoods.getOrderPoint()));
        parameters.add(new TParameter<>("OrderCount", invGoods.getOrderCount()));
        parameters.add(new TParameter<>("GoodIdentity", invGoods.getGoodIdentity()));
        parameters.add(new TParameter<>("GSerialCode", invGoods.getgSerialCode()));
//        parameters.add(new TParameter<>("ImageGoods", invGoods.getImageGoods()));
        parameters.add(new TParameter<>("ImageGoods", null));
        parameters.add(new TParameter<>("GoodsBriefName", invGoods.getGoodsBriefName()));
        parameters.add(new TParameter<>("CustomTarrifNo", invGoods.getCustomTarrifNo()));
        parameters.add(new TParameter<>("IsBasket", invGoods.getIsBasket()));
        parameters.add(new TParameter<>("SecGoodsCode", invGoods.getSecGoodsCode()));
        parameters.add(new TParameter<>("BarCode", invGoods.getBarCode()));
        parameters.add(new TParameter<>("BaseFee", invGoods.getBaseFee()));
        parameters.add(new TParameter<>("OrderPick", invGoods.getOrderPick()));
        parameters.add(new TParameter<>("PricingMethod", invGoods.getPricingMethod()));
//        parameters.add(new TParameter<>("GoodsPositionID", invGoods.getGoodsP()));
        parameters.add(new TParameter<>("GoodsDiscountPercent", invGoods.getGoodsDiscountPercent()));
        parameters.add(new TParameter<>("GoodsDiscountPrice", invGoods.getGoodsDiscountPrice()));
        parameters.add(new TParameter<>("IsNotActive", invGoods.getIsNotActive()));
//        parameters.add(new TParameter<>("IsUpdate", invGoods.));
//        parameters.add(new TParameter<>("WebUser  Type",));
        updSP("InvUpdGoods", parameters);
        return invShowGoodsByID(goodsID);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "goodsID", "goodsID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "goodsCode", "کالا|کد", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "fullGoodsCode", "کالا|کد کالا", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "secGoodsCode", "کالا|کد طبقه", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "unitDesc", "واحد کالا|شرح", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "typeDesc", "نوع کالا|شرح", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "typeCode", "نوع کالا|کد", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "groupDesc", "کالا|شرح", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "goodsDesc", "goodsDesc", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "unitID", "unitID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "unitCode", "unitCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "groupID", "groupID", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "groupCode", "groupCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "typeID", "typeID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "tafsiliID", "tafsiliID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "techInfo", "techInfo", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 60, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 60, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "latinDesc", "latinDesc", Type.STRING, 60, true, true, false));
        cols.add(new Col(null, "tafsiliCode", "tafsiliCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "tafsiliTypeID", "tafsiliTypeID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "tafsiliTypeDesc", "tafsiliTypeDesc", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "minQuantity", "minQuantity", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "maxQuantity", "maxQuantity", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "orderCount", "orderCount", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "orderPoint", "orderPoint", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "goodIdentity", "goodIdentity", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "goodIdentityDesc", "goodIdentityDesc", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "gSerialCode", "gSerialCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "countGoods", "countGoods", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "goodspositionCode", "goodspositionCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "goodsPositionDesc", "goodsPositionDesc", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "hasInvFlow", "hasInvFlow", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "hasBuyFlow", "hasBuyFlow", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "hasSaleFlow", "hasSaleFlow", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "coEffValue", "coEffValue", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "barCode", "barCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "baseFee", "baseFee", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "otherBarCode", "otherBarCode", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "orderPick", "orderPick", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "pricingDesc", "pricingDesc", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "secUnitName", "secUnitName", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "goodsBriefName", "goodsBriefName", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "customTarrifNo", "customTarrifNo", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "isBasket", "isBasket", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "pricingMethod", "pricingMethod", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "goodsPositionID", "goodsPositionID", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "hasAnalysis", "hasAnalysis", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "goodsDiscountPercent", "goodsDiscountPercent", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "creatorName", "creatorName", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "modifierName", "modifierName", Type.STRING, 60, false, false, false));
        cols.add(new Col(null, "goodsDiscountPrice", "goodsDiscountPrice", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "isNotActive", "isNotActive", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "isFixFee", "isFixFee", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "isProductable", "isProductable", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "isBuyable", "isBuyable", Type.BOOLEAN, 60, false, false, false));
        cols.add(new Col(null, "minFee", "minFee", Type.DECIMAL, 60, false, false, false));
        cols.add(new Col(null, "maxFee", "maxFee", Type.DECIMAL, 60, false, false, false));
        return new Meta(cols);
    }
}
