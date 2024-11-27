package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmDashboardList;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 3/4/23
 *
 * @author Erfan Akhavan
 */
public interface CrmDashboardListRepository extends TCrudRepository<CrmDashboardList>, CrudRepository<CrmDashboardList, BigDecimal> {

    default List<CrmDashboardList> crmShowDashboardList(CrmDashboardList crmDashboardList) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmDashboardList._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmDashboardList._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmDashboardList._pageFilter()));
        return showSP("CrmShowDashboardList", tParameters, true);
    }

    default CrmDashboardList crmShowDashboardListByID(BigDecimal listId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND main.listID = " + listId));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowDashboardList", tParameters, true).get(0);
    }

    default CrmDashboardList crmInsDashboardList(CrmDashboardList crmDashboardList) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ListDesc", crmDashboardList.getListDesc()));
        tParameters.add(new TParameter<>("ListResourceData", crmDashboardList.getListResourceData()));
        tParameters.add(new TParameter<>("ListResourceMeta", crmDashboardList.getListResourceMeta()));
        tParameters.add(new TParameter<>("ListType", crmDashboardList.getListType()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newId = insSP("CrmInsDashboardList", tParameters);
        return crmShowDashboardListByID(newId);
    }

    default CrmDashboardList crmUpdDashboardList(BigDecimal listId, CrmDashboardList crmDashboardList) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ListID", listId));
        tParameters.add(new TParameter<>("ListDesc", crmDashboardList.getListDesc()));
        tParameters.add(new TParameter<>("ListResourceData", crmDashboardList.getListResourceData()));
        tParameters.add(new TParameter<>("ListResourceMeta", crmDashboardList.getListResourceMeta()));
        tParameters.add(new TParameter<>("ListType", crmDashboardList.getListType()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdDashboardList", tParameters);
        return crmShowDashboardListByID(listId);
    }

    default void crmDelDashboardList(BigDecimal listId) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ListID", listId));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelDashboardList", tParameters);
    }


}
