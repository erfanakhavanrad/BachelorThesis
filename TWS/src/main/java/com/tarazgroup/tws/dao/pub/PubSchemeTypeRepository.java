package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubSchemeType;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface PubSchemeTypeRepository extends TCrudRepository<PubSchemeType>, CrudRepository<PubSchemeType, BigDecimal> {
    default List<PubSchemeType> pubShowSchemeType(PubSchemeType pubSchemeType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubSchemeType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubSchemeType._serverFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", pubSchemeType._pageFilter()));
        return showSP("PubShowSchemeType", tParameters, true);
    }

    default PubSchemeType pubShowSchemeTypeByID(BigDecimal schemeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SchemeID = " + schemeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowSchemeType", tParameters, true).get(0);
    }

    default PubSchemeType pubInsSchemeType(PubSchemeType pubSchemeType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SchemeCode", pubSchemeType.getSchemeCode()));
        tParameters.add(new TParameter<>("SchemeDesc", pubSchemeType.getSchemeDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SystemID", logLogins.getSystemId()));
        BigDecimal newID = insSP("PubInsSchemeType", tParameters);
        return pubShowSchemeTypeByID(newID);
    }

    default void pubDelSchemeType(BigDecimal schemeID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SchemeID", schemeID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
    }

    default PubSchemeType pubUpdSchemeType(BigDecimal schemeID, PubSchemeType pubSchemeType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SchemeID", schemeID));
        tParameters.add(new TParameter<>("SchemeCode", pubSchemeType.getSchemeCode()));
        tParameters.add(new TParameter<>("SchemeDesc", pubSchemeType.getSchemeDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("SystemID", logLogins.getSystemId()));
        return pubShowSchemeTypeByID(schemeID);
    }
}
