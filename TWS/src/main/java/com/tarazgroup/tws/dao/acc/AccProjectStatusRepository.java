package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccProjectStatus;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-17, 2022
 ***/
public interface AccProjectStatusRepository extends TCrudRepository<AccProjectStatus>, CrudRepository<AccProjectStatus, BigDecimal> {
    default List<AccProjectStatus> accShowProjectStatus(AccProjectStatus accProjectStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accProjectStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accProjectStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accProjectStatus._pageFilter()));
        return showSP("AccShowProjectStatus", tParameters, true);
    }

    default AccProjectStatus accShowProjectStatusByID(BigDecimal statusId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.StatusId = " + statusId));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowProjectStatus", tParameters, true).get(0);
    }

    default AccProjectStatus accInsProjectStatus(AccProjectStatus accProjectStatus) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusCode", accProjectStatus.getStatusCode()));
        tParameters.add(new TParameter<>("StatusDesc", accProjectStatus.getStatusDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", accProjectStatus.getModifierID()));
        tParameters.add(new TParameter<>("IsInActiveStat", accProjectStatus.getIsInActiveStat()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsProjectStatus", tParameters);
        return accShowProjectStatusByID(newID);
    }

    default AccProjectStatus accUpdProjectStatus(BigDecimal statusId, AccProjectStatus accProjectStatus) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusId", statusId));
        tParameters.add(new TParameter<>("StatusCode", accProjectStatus.getStatusCode()));
        tParameters.add(new TParameter<>("StatusDesc", accProjectStatus.getStatusDesc()));
        tParameters.add(new TParameter<>("ModifierID", accProjectStatus.getModifierID()));
        tParameters.add(new TParameter<>("IsInActiveStat", accProjectStatus.getIsInActiveStat()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdProjectStatus", tParameters);
        return accShowProjectStatusByID(statusId);
    }

    default void accDelProjectStatus(BigDecimal statusId) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusId", statusId));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelProjectStatus", tParameters);
    }
}
