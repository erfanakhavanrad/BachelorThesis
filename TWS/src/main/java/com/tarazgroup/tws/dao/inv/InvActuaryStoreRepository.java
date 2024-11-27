package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface InvActuaryStoreRepository extends TCrudRepository<InvActuaryStore>, CrudRepository<InvActuaryStore, BigDecimal> {
    //    GET All
    default List<InvActuaryStore> invShowActuaryStore(InvActuaryStore invActuaryStore) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invActuaryStore._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invActuaryStore._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invActuaryStore._pageFilter()));
        return showSP("InvShowActuaryStore", tParameters, true);
    }

    //    GET BY ID
    default InvActuaryStore invShowActuaryStoreByID(BigDecimal selectStoreID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SelectStoreID=" + selectStoreID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowActuaryStore", tParameters, true).get(0);
    }

    //    POST
    default InvActuaryStore invInsActuaryStore(InvActuaryStore invActuaryStore) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("actuaryID", invActuaryStore.getActuaryID()));
        tParameters.add(new TParameter("StoreID", invActuaryStore.getActuaryID()));
        tParameters.add(new TParameter("TafsiliID", invActuaryStore.getTafsiliID()));
//        tParameters.add(new TParameter("CreatorID", invActuaryStore.getCreatorID()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter("YearID", invActuaryStore.getActuaryID()));

        BigDecimal newID = insSP("InvInsActuaryStore", tParameters);
        return invShowActuaryStoreByID(newID);

//        @actuaryID  decimal(18,0)  ,
//                @StoreID  decimal(18,0)  ,
//                @TafsiliID  decimal(18,0)  ,
//                @CreatorID  decimal(18,0)  ,
//                @ModifierID  decimal(18,0)  ,
//                @Result	decimal output,
//                @ErrMsg	nvarchar(255) output,
//                @LoginID	decimal,
//                @NewID	decimal output,
//                @YearID	decimal

    }

    //    PUT
    default InvActuaryStore invUpdActuaryStore(BigDecimal selectStoreID, InvActuaryStore invActuaryStore) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SelectStoreID", selectStoreID));
        tParameters.add(new TParameter<>("actuaryID", invActuaryStore.getActuaryID()));
        tParameters.add(new TParameter<>("StoreID", invActuaryStore.getStoreID()));
        tParameters.add(new TParameter<>("TafsiliID", invActuaryStore.getTafsiliID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID", invActuaryStore.getYearID()));
        updSP("InvUpdActuaryStore", tParameters);
        return invShowActuaryStoreByID(selectStoreID);
    }

    //    DELETE
    default void invDelActuaryStore(BigDecimal selectStoreID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("selectStoreID", selectStoreID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelActuaryStore", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "selectStoreID", "selectStoreID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "actuaryID", "actuaryID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "actuaryCode", "رویه|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "actuaryDesc", "رویه|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "actuaryCount", "رویه|تعداد دفعات شمارش", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "storeID", "کد فروشگاه", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeCode", "انبار|کد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeName", "انبار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tafsiliID", "tafsiliID", Type.INTEGER, 0, true, true, false));
        cols.add(new Col(null, "tafsiliDesc", "مسئول انبارگردانی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tafsiliCode", "tafsiliCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, true, true, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, true, false));
        cols.add(new Col(null, "yearID", "yearID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "rowCnt", "rowCnt", Type.STRING, 0, true, false, false));
        return new Meta(cols);
    }
//    default Meta meta() {
//        ArrayList<Col> cols = new ArrayList<>();
//        cols.add(new Col(null, "bankId", "bankId", Type.DECIMAL, 0, false, false, true));
//        cols.add(new Col(null, "bankCode", "کد بانک", Type.STRING, 100, true, false, false));
//        cols.add(new Col(null, "taxCode", "کد مالیاتی", Type.STRING, 130, true, true, false));
//        cols.add(new Col(null, "bankName", "نام بانک", Type.STRING, 100, true, true, false));
//        cols.add(new Col(null, "bankLatinName", "نام لاتین بانک", Type.STRING, 120, true, true, false));
//        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
//        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 100, false, false, false));
//        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
//        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
//        return new Meta(cols);

}
