/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvStore;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface InvStoreRepository extends CrudRepository<InvStore, BigDecimal>, TCrudRepository<InvStore> {

    default List<InvStore> invShowStore(InvStore invStore, BigDecimal userID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", invStore._pageFilter()));
        parameters.add(new TParameter<>("UserID", userID));
        return showSP("InvShowStore", parameters, true);
    }

    default InvStore invShowStoreByID(BigDecimal StoreID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", " AND main.StoreID = " + StoreID));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", null));
        parameters.add(new TParameter<>("YearFilter", null));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", null));
        parameters.add(new TParameter<>("UserID", null));
        return showSP("InvShowStore", parameters, true).get(0);
    }

    default InvStore invInsStore(InvStore invStore) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("StoreCode", invStore.getStoreCode()));
        parameters.add(new TParameter<>("StoreName", invStore.getStoreName()));
        parameters.add(new TParameter<>("FixAsset", invStore.getFixASSET()));
        parameters.add(new TParameter<>("CreatorID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("TafsiliTypeID", invStore.getTafsiliTypeID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("IsLCStore", invStore.getIsLCStore()));
        parameters.add(new TParameter<>("InvPriority", invStore.getInvPriority()));
        parameters.add(new TParameter<>("BriefName", invStore.getBriefName()));
        BigDecimal newID = insSP("InvInsStore", parameters);
        return invShowStoreByID(newID);
    }

    default void invDelStore(BigDecimal storeID) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("StoreID", storeID));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        delSP("InvDelStore", parameters);
    }

    default InvStore invUpdStore(BigDecimal storeID, InvStore invStore) {
        LogLogins logins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("StoreID", storeID));
        parameters.add(new TParameter<>("StoreCode", invStore.getStoreCode()));
        parameters.add(new TParameter<>("StoreName", invStore.getStoreName()));
        parameters.add(new TParameter<>("FixAsset", invStore.getFixASSET()));
        parameters.add(new TParameter<>("ModifierID", logins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("LoginID", logins.getLoginId()));
        parameters.add(new TParameter<>("IsLCStore", invStore.getIsLCStore()));
        parameters.add(new TParameter<>("InvPriority", invStore.getInvPriority()));
        parameters.add(new TParameter<>("BriefName", invStore.getBriefName()));
        updSP("InvUpdStore", parameters);
        return invShowStoreByID(storeID);

    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "storeID", "storeID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "storeCode", "کد انبار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "نام انبار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tafsiliCode", "کد تفصیلی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "briefName", "نام اختصاری", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "fixASSET", "انبار دارایی ثابت", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "isLCStore", "انبار اعتبارات", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "invPriority", "اولویت انتخاب انبار در اسناد خودکار (دارای موجودی کالا)", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "tafsiliID", "tafsiliID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "tafsiliTypeID", "tafsiliTypeID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);

    }
}
