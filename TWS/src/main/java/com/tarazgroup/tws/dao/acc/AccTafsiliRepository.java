package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccTafsili;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.exception.TNoContentException;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface AccTafsiliRepository extends CrudRepository<AccTafsili, BigDecimal>, TCrudRepository<AccTafsili> {

    default List<AccTafsili> accShowTafsili(AccTafsili accTafsili) throws TNoContentException {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter", null));
        parameters.add(new TParameter<>("OtherFilter", null));
        parameters.add(new TParameter<>("ServerFilter", accTafsili._serverFilter()));
        parameters.add(new TParameter<>("YearFilter", accTafsili._yearFilter()));
        parameters.add(new TParameter<>("UserAccessFilter", null));
        parameters.add(new TParameter<>("PageFilter", accTafsili._pageFilter()));
        return showSP("AccShowTafsili", parameters, true);
    }

    default AccTafsili accShowTafsiliByID(BigDecimal TafsiliID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("Filter"," AND Main.TafsiliID = " + TafsiliID));
        parameters.add(new TParameter<>("OtherFilter",null));
        parameters.add(new TParameter<>("ServerFilter",null));
        parameters.add(new TParameter<>("YearFilter",null));
        parameters.add(new TParameter<>("UserAccessFilter",null));
        parameters.add(new TParameter<>("PageFilter",null));
        return showSP("AccShowTafsili",parameters, true).get(0);
    }

    default AccTafsili accInsTafsili(AccTafsili accTafsili) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter<>("TafsiliCode", accTafsili.getTafsiliCode()));
        parameters.add(new TParameter<>("TafsiliDesc", accTafsili.getTafsiliDesc()));
        parameters.add(new TParameter<>("TafsiliDesc1", accTafsili.getTafsiliDesc1()));
        parameters.add(new TParameter<>("TafsiliDesc2", accTafsili.getTafsiliDesc2()));
        parameters.add(new TParameter<>("TafsiliTypeID", accTafsili.getTafsiliTypeID()));
        parameters.add(new TParameter<>("ReferID", accTafsili.getReferID()));
        parameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        parameters.add(new TParameter<>("IsNotActive", accTafsili.isNotActive()));
//        parameters.add(new TParameter<>("ErroronDuplicate", ));
        parameters.add(new TParameter<>("TafsiliCode", accTafsili.getTafsiliCode()));
        BigDecimal newID = insSP("AccInsTafsili", parameters);
        return accShowTafsiliByID(newID);
    }

    default AccTafsili accUpdTafsili(AccTafsili accTafsili, BigDecimal accTafsiliID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> parameters = new ArrayList<>();
        parameters.add(new TParameter("TafsiliID", accTafsiliID));
        parameters.add(new TParameter("TafsiliDesc", accTafsili.getTafsiliDesc()));
        parameters.add(new TParameter("TafsiliDesc1", accTafsili.getTafsiliDesc1()));
        parameters.add(new TParameter("TafsiliDesc2", accTafsili.getTafsiliDesc2()));
        parameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        parameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        parameters.add(new TParameter("IsNotActive", accTafsili.isNotActive()));
        updSP("AccUpdTafsili", parameters);
        return accShowTafsiliByID(accTafsiliID);
    }

    default void accAutoTafsili(BigDecimal tafsiliTypeID) {
        List<TParameter<?>> parameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        parameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        parameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        parameters.add(new TParameter<>("TafsiliTypeID", tafsiliTypeID));
        noPKUpdSP("AccAutoTafsili", parameters);
    }

        /*default AccTafsili accDelTafsili(BigDecimal accTafsiliID){
        LogLogins logLogins = fetchUserDetail();
        List<TParameter> parameters = new ArrayList<>();
        parameters.add(new TParameter("TafsiliID",accTafsiliID));
        parameters.add(new TParameter("RefTableName",""));
        parameters.add(new TParameter("RefFieldName",""));
        parameters.add(new TParameter("ReferID",))
        }*/
}
