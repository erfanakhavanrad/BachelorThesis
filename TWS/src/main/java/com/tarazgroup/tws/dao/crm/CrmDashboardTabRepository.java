package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmDashboardTab;
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
public interface CrmDashboardTabRepository extends TCrudRepository<CrmDashboardTab>, CrudRepository<CrmDashboardTab, BigDecimal> {

    default List<CrmDashboardTab> crmShowDashboardTab(CrmDashboardTab crmDashboardTab) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmDashboardTab._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmDashboardTab._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmDashboardTab._pageFilter()));
        return showSP("CrmShowDashboardTab", tParameters, true);
    }

    default CrmDashboardTab crmShowDashboardTabByID(BigDecimal tabId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND main.TabId = " + tabId));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowDashboardTab", tParameters, true).get(0);
    }

    default CrmDashboardTab crmInsDashboardTab(CrmDashboardTab crmDashboardTab) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TabName", crmDashboardTab.getTabName()));
        tParameters.add(new TParameter<>("CategoryID", crmDashboardTab.getCategoryID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newId = insSP("CrmInsDashboardTab", tParameters);
        return crmShowDashboardTabByID(newId);
    }

    default CrmDashboardTab crmUpdDashboardTab(BigDecimal tabId, CrmDashboardTab crmDashboardTab) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TabID", tabId));
        tParameters.add(new TParameter<>("TabName", crmDashboardTab.getTabName()));
        tParameters.add(new TParameter<>("CategoryID", crmDashboardTab.getCategoryID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdDashboardTab", tParameters);
        return crmShowDashboardTabByID(tabId);
    }

    default void crmDelDashboardTab(BigDecimal tabId) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TabID", tabId));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelDashboardTab", tParameters);
    }


}
