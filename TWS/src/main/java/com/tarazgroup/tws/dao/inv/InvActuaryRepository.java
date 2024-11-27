package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvActuary;
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
public interface InvActuaryRepository extends TCrudRepository<InvActuary>, CrudRepository<InvActuary, BigDecimal> {
    //    GET All
    default List<InvActuary> invShowActuary(InvActuary invActuary) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invActuary._serverFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("YearFilter", invActuary._yearFilter()));
        tParameters.add(new TParameter<>("PageFilter", invActuary._pageFilter()));
        return showSP("InvShowActuary", tParameters, true);
    }

    //    GET By ID
    default InvActuary invShowActuaryByID(BigDecimal actuaryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And Main.ActuaryID=" + actuaryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvShowActuary", tParameters, true).get(0);
    }

    //    POST
    default InvActuary invInsActuary(InvActuary invActuary) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActuaryCode", invActuary.getActuaryCode()));
        tParameters.add(new TParameter<>("ActuaryDesc", invActuary.getActuaryDesc()));
        tParameters.add(new TParameter<>("ActuaryCount", invActuary.getActuaryCount()));
        tParameters.add(new TParameter<>("CounterPart2", invActuary.getCounterPart2()));
        tParameters.add(new TParameter<>("CounterPart3", invActuary.getCounterPart3()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("DifType1", invActuary.getDifType1()));
        tParameters.add(new TParameter<>("DifType2", invActuary.getDifType2()));
        tParameters.add(new TParameter<>("DifType3", invActuary.getDifType3()));
        BigDecimal newID = insSP("InvInsActuary", tParameters);
        return invShowActuaryByID(newID);
    }

    //    PUT
    default InvActuary invUpdActuary(BigDecimal actuaryID, InvActuary invActuary) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActuaryID", actuaryID));
        tParameters.add(new TParameter<>("ActuaryCode", invActuary.getActuaryCode()));
        tParameters.add(new TParameter<>("ActuaryDesc", invActuary.getActuaryDesc()));
        tParameters.add(new TParameter<>("ActuaryCount", invActuary.getActuaryCount()));
        tParameters.add(new TParameter<>("CounterPart1", invActuary.getCounterPart1()));
        tParameters.add(new TParameter<>("CounterPart2", invActuary.getCounterPart2()));
        tParameters.add(new TParameter<>("CounterPart3", invActuary.getCounterPart3()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("DifType1", invActuary.getDifType1()));
        tParameters.add(new TParameter<>("DifType2", invActuary.getDifType2()));
        tParameters.add(new TParameter<>("DifType3", invActuary.getDifType3()));
        updSP("InvUpdActuary", tParameters);
        return invShowActuaryByID(actuaryID);
    }

    //    DELETE
    default void invDelActuary(BigDecimal actuaryID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActuaryID", actuaryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelActuary", tParameters);
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "actuaryID", "actuaryID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "actuaryCode", "کد", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "actuaryDesc", "شرح", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "actuaryCount", "تعداد دفعات شمارش", Type.INTEGER, 100, true, true, false));
        cols.add(new Col(null, "counterPart1", "counterPart1", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "counterPart2", "counterPart2", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "counterPart3", "counterPart3", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "difType1", "difType1", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "difType2", "difType2", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "difType3", "difType3", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "rowCnt", "rowCnt", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }


}
