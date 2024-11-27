package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmSysSetup;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Sep-06, 2022
 ***/
public interface CrmSysSetupRepository extends TCrudRepository<CrmSysSetup>, CrudRepository<CrmSysSetup, BigDecimal> {
    default List<CrmSysSetup> crmShowSysSetup(CrmSysSetup crmSysSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmSysSetup._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmSysSetup._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmSysSetup._pageFilter()));
        return showSP("CrmShowSysSetup", tParameters, true);
    }


    //    GET BY ID
    default CrmSysSetup crmShowSysSetupByID(BigDecimal sysSetupID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND SysSetupID=" + sysSetupID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowSysSetup", tParameters, true).get(0);
    }

    default CrmSysSetup crmUpdSysSetup(BigDecimal sysSetupID, CrmSysSetup crmSysSetup) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SysSetupID", sysSetupID));
        tParameters.add(new TParameter<>("SystemTitle", crmSysSetup.getSystemTitle()));
        tParameters.add(new TParameter<>("SystemLogoImage", crmSysSetup.getSystemLogoImage()));
        tParameters.add(new TParameter<>("SystemFavIcon", crmSysSetup.getSystemFavIcon()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdSysSetup", tParameters);
        return crmShowSysSetupByID(sysSetupID);
    }

}
