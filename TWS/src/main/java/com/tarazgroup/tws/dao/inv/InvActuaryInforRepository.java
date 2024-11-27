package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvActuaryInfor;
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
public interface InvActuaryInforRepository extends TCrudRepository<InvActuaryInfor>, CrudRepository<InvActuaryInfor, BigDecimal> {
        //    GET All
    default List<InvActuaryInfor> invShowActuaryInfor(InvActuaryInfor invActuaryInfor) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invActuaryInfor._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invActuaryInfor._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", invActuaryInfor._pageFilter()));
        return showSP("InvShowActuaryInfor", tParameters, true);
    }

    // GET By ID
    default InvActuaryInfor invShowActuaryInforByID(BigDecimal actuaryInforID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And  Main.ActuaryInforID=" + actuaryInforID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowActuaryInfor", tParameters, true).get(0);
    }

    // POST
    default InvActuaryInfor invInsActuaryInfo(InvActuaryInfor invActuaryInfor) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActuaryStoreID", invActuaryInfor.getActuaryStoreID()));
        tParameters.add(new TParameter<>("ActuaryDate", invActuaryInfor.getActuaryDate()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ToDate", invActuaryInfor.getToDate()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsActuaryInfor", tParameters);
        return invShowActuaryInforByID(newID);
    }

    // PUT
    default InvActuaryInfor invUpdActuaryInfo(BigDecimal actuaryInforID, InvActuaryInfor invActuaryInfor) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActuaryInforID", actuaryInforID));
        tParameters.add(new TParameter<>("ActuaryStoreID", invActuaryInfor.getActuaryStoreID()));
        tParameters.add(new TParameter<>("ActuaryDate", invActuaryInfor.getActuaryDate()));
        tParameters.add(new TParameter<>("ToDate", invActuaryInfor.getToDate()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("InvUpdActuaryInfor", tParameters);
        return invShowActuaryInforByID(actuaryInforID);
    }

    // DELETE
    default void invDelActuaryInfo(BigDecimal actuaryInforID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActuaryInforID", actuaryInforID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelActuaryInfor", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "actuaryInforID", "actuaryInforID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "actuaryStoreID", "actuaryStoreID", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "actuaryCode", "رویه|کد", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "actuaryDesc", "رویه|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "actuaryCount", "رویه|تعداد دفعات شمارش", Type.INTEGER, 120, true, true, false));
        cols.add(new Col(null, "toDate", "بازه زمانی|تا تاریخ", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "storeId", "storeId", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "storeCode", "انبار|کد", Type.STRING, 120, true, false, false));
        cols.add(new Col(null, "storeName", "انبار|شرح", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "tafsiliDesc", "مسئول انبار گردانی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "actuaryDate", "بازه زمانی|تا تاریخ", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, false, false, false));
//        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "difType1", "difType1", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "difType2", "difType2", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "difType3", "difType3", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "rowCnt", "rowCnt", Type.INTEGER, 100, false, false, false));
        return new Meta(cols);
    }
}
