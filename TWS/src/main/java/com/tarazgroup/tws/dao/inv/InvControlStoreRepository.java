package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvControlStore;
import com.tarazgroup.tws.model.log.LogLogins;
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
public interface InvControlStoreRepository extends TCrudRepository<InvControlStore>, CrudRepository<InvControlStore, BigDecimal> {
    default List<InvControlStore> invShowControlStore(InvControlStore invControlStore) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invControlStore._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invControlStore._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invControlStore._pageFilter()));
        return showSP("InvShowControlStore", tParameters, true);
    }

    default InvControlStore invShowControlStoreByID(BigDecimal controlStoreID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And Main.ControlStoreID=" + controlStoreID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowControlStore", tParameters, true).get(0);
    }

    default InvControlStore invInsControlStore(InvControlStore invControlStore) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StoreID", invControlStore.getStoreID()));
        tParameters.add(new TParameter<>("StartDate", invControlStore.getStartDate()));
        tParameters.add(new TParameter<>("FinishDate", invControlStore.getFinishDate()));
        tParameters.add(new TParameter<>("StartDateG", invControlStore.getStartDateG()));
        tParameters.add(new TParameter<>("FinishDateG", invControlStore.getFinishDateG()));
        tParameters.add(new TParameter<>("ControllerID", invControlStore.getControllerID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", invControlStore.getYearID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsControlStore", tParameters);
        return invShowControlStoreByID(newID);
    }

    default InvControlStore invUpdControlStore(BigDecimal controlStoreID, InvControlStore invControlStore) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ControlStoreID", controlStoreID));
        tParameters.add(new TParameter<>("StoreID", invControlStore.getStoreID()));
        tParameters.add(new TParameter<>("StartDate", invControlStore.getStartDate()));
        tParameters.add(new TParameter<>("FinishDate", invControlStore.getFinishDate()));
        tParameters.add(new TParameter<>("StartDateG", invControlStore.getStartDateG()));
        tParameters.add(new TParameter<>("FinishDateG", invControlStore.getFinishDateG()));
        tParameters.add(new TParameter<>("ControllerID", invControlStore.getControllerID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("YearID", invControlStore.getYearID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("InvUpdControlStore", tParameters);
        return invShowControlStoreByID(controlStoreID);
    }

    default void invDelControlStore(BigDecimal controlStoreID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ControlStoreID", controlStoreID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelControlStore", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "controlStoreID", "controlStoreID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "storeID", "آی دی فروشگاه", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "startDate", "تاریخ شروع", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "finishDate", "تاریخ پایان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "startDateG", "StartDateG", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "finishDateG", "FinishDateG", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "controllerID", "ControllerID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "ServerID", Type.DECIMAL, 120, false, false, false));
        cols.add(new Col(null, "creatorID", "CreatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "ModifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "CreateDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "yearID", "YearID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "storeCode", "کد انبار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "نام انبار", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "controllerName", "کنترل کننده", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "rowCnt", "تعداد ردیف", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);
    }


}

