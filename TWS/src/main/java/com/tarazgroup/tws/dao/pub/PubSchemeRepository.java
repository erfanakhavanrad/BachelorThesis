package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubScheme;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface PubSchemeRepository extends TCrudRepository<PubScheme>, CrudRepository<PubScheme, BigDecimal> {
    default List<PubScheme> pubShowScheme(PubScheme pubScheme) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubScheme._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubScheme._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", pubScheme._pageFilter()));
        return showSP("PubShowScheme", tParameters, true);
    }

    default PubScheme pubShowSchemeByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.mID = " + mID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowScheme", tParameters, true).get(0);
    }

    default PubScheme pubInsScheme(PubScheme pubScheme) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SchemeID", pubScheme.getSchemeID()));
        tParameters.add(new TParameter<>("ControlType", pubScheme.getControlType()));
        tParameters.add(new TParameter<>("PriorityLevel", pubScheme.getPriorityLevel()));
        tParameters.add(new TParameter<>("ControllerID", pubScheme.getControllerID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsFinalConfirm", pubScheme.getIsFinalConfirm()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsSignature", pubScheme.gerIsSignature()));
        tParameters.add(new TParameter<>("IsPersonCartable", pubScheme.getIsPersonCartable()));
        tParameters.add(new TParameter<>("SecretariatID", pubScheme.getSecretariatID()));
        tParameters.add(new TParameter<>("IsDelManager", pubScheme.getIsDelManager()));
        tParameters.add(new TParameter<>("DeputyUserIds", pubScheme.getDeputyUserIDs()));
        BigDecimal newID = insSP("PubInsScheme", tParameters);
        return pubShowSchemeByID(newID);
    }

    default void pubDelScheme(BigDecimal mID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("mID", mID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelScheme", tParameters);
    }

    default PubScheme pubUpdScheme(BigDecimal mID, PubScheme pubScheme) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("mID", mID));
        tParameters.add(new TParameter<>("SchemeID", pubScheme.getSchemeID()));
        tParameters.add(new TParameter<>("ControlType", pubScheme.getControlType()));
        tParameters.add(new TParameter<>("PriorityLevel", pubScheme.getPriorityLevel()));
        tParameters.add(new TParameter<>("ControllerID", pubScheme.getControllerID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsFinalConfirm", pubScheme.getIsFinalConfirm()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsSignature", pubScheme.gerIsSignature()));
        tParameters.add(new TParameter<>("IsPersonCartable", pubScheme.getIsPersonCartable()));
        tParameters.add(new TParameter<>("SecretariatID", pubScheme.getSecretariatID()));
        tParameters.add(new TParameter<>("IsDelManager", pubScheme.getIsDelManager()));
        tParameters.add(new TParameter<>("DeputyUserIds", pubScheme.getDeputyUserIDs()));
        updSP("PubUpdScheme", tParameters);
        return pubShowSchemeByID(mID);
    }
}
