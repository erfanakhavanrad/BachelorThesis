package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmDashboardItem;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 3/6/23
 *
 * @author Erfan Akhavan
 */
public interface CrmDashboardItemRepository extends TCrudRepository<CrmDashboardItem>, CrudRepository<CrmDashboardItem, BigDecimal> {

    default List<CrmDashboardItem> crmShowDashboardItem(CrmDashboardItem crmDashboardItem) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmDashboardItem._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmDashboardItem._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmDashboardItem._pageFilter()));
        return showSP("CrmShowDashboardItem", tParameters, true);
    }

    default CrmDashboardItem crmShowDashboardItemByID(BigDecimal itemId) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND main.itemId = " + itemId));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowDashboardItem", tParameters, true).get(0);
    }


    default CrmDashboardItem crmInsDashboardItem(CrmDashboardItem crmDashboardItem) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ListID", crmDashboardItem.getListID()));
        tParameters.add(new TParameter<>("TabID", crmDashboardItem.getTabID()));
        tParameters.add(new TParameter<>("CategoryID", crmDashboardItem.getCategoryID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newId = insSP("CrmInsDashboardItem", tParameters);
        return crmShowDashboardItemByID(newId);
    }


    default CrmDashboardItem crmUpdDashboardItem(BigDecimal itemId, CrmDashboardItem crmDashboardItem) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ItemID", itemId));
        tParameters.add(new TParameter<>("ListID", crmDashboardItem.getListID()));
        tParameters.add(new TParameter<>("TabID", crmDashboardItem.getTabID()));
        tParameters.add(new TParameter<>("CategoryID", crmDashboardItem.getCategoryID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdDashboardItem", tParameters);
        return crmShowDashboardItemByID(itemId);
    }

    default void crmDelDashboardItem(BigDecimal itemId) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ItemID", itemId));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelDashboardItem", tParameters);
    }


}
