package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubSysStoreSetup;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface PubSysStoreSetupRepository extends TCrudRepository<PubSysStoreSetup>, CrudRepository<PubSysStoreSetup, BigDecimal> {

    default List<PubSysStoreSetup> pubSysStoreSetupByStore(PubSysStoreSetup pubSysStoreSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubSysStoreSetup._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubSysStoreSetup._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubSysStoreSetup._pageFilter()));
        return showSP("PubShowSysStoreSetup", tParameters, true);
    }

    default PubSysStoreSetup pubSysStoreSetupByStoreID(BigDecimal storeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "AND main.storeID=" + storeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", " AND storeID=" + storeID + "?,?"));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowSysStoreSetup", tParameters, true).get(0);
    }

    default PubSysStoreSetup pubInsSysStoreSetupByStore(PubSysStoreSetup pubSysStoreSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("ControlInventory", pubSysStoreSetup.getControlInventory()));
        tParameters.add(new TParameter<>("IsNegativeStock", pubSysStoreSetup.getIsNegativeStock()));
        tParameters.add(new TParameter<>("IsAllowableQuantity", pubSysStoreSetup.getIsAllowableQuantity()));
        tParameters.add(new TParameter<>("IsComputeValue", pubSysStoreSetup.getIsComputeValue()));
        tParameters.add(new TParameter<>("IsStoreAllocated", pubSysStoreSetup.getIsStoreAllocated()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("StoreID", pubSysStoreSetup.getStoreID()));
        tParameters.add(new TParameter<>("IsTaxInfoControl", pubSysStoreSetup.getIsTaxInfoControl()));
        BigDecimal newID = insSP("PubInsSysStoreSetup", tParameters);
        return pubSysStoreSetupByStoreID(newID);
    }

    default PubSysStoreSetup pubUpdSysStoreSetupByStore(BigDecimal storeID, PubSysStoreSetup pubSysStoreSetup) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ControlInventory", pubSysStoreSetup.getControlInventory()));
        tParameters.add(new TParameter<>("IsNegativeStock", pubSysStoreSetup.getIsNegativeStock()));
        tParameters.add(new TParameter<>("IsAllowableQuantity", pubSysStoreSetup.getIsAllowableQuantity()));
        tParameters.add(new TParameter<>("IsComputeValue", pubSysStoreSetup.getIsComputeValue()));
        tParameters.add(new TParameter<>("IsStoreAllocated", pubSysStoreSetup.getIsStoreAllocated()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("StoreID", pubSysStoreSetup.getStoreID()));
        tParameters.add(new TParameter<>("IsTaxInfoControl", pubSysStoreSetup.getIsTaxInfoControl()));
        updSP("PubInsSysStoreSetup", tParameters);
        return pubSysStoreSetupByStoreID(storeID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "storeID", "storeID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "storeCode", "انبار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "انبار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "controlInventory", "کنترل موجود هنگام صدور سند صادره", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isNegativeStock", "کنترل موجودی انبار هنگام حذف سند وارده", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isAllowableQuantity", "خطای کنترل ظرفیت فروش", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isComputeValue", "تغییر ضریب واحد فرعی در سند", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isStoreAllocated", "انتخاب انبار در صدور سند حسابداری بر اساس کالای تخصیص یافته", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isTaxInfoControl", "بررسی اطلاعات مالیاتی اشخاص هنگام ثبت سند اسناد", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }

}
