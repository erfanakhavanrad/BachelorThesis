package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmPerCom;
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
 * @author Aref Azizi
 * 8/30/22
 */
public interface CrmPerComRepository extends TCrudRepository<CrmPerCom>, CrudRepository<CrmPerCom, BigDecimal> {

    default List<CrmPerCom> crmShowPerCom(CrmPerCom crmPerCom) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmPerCom._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmPerCom._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmPerCom._pageFilter()));
        return showSP("CrmShowPerCom", tParameters, true);
    }

    default CrmPerCom crmShowPerComByID(BigDecimal perComID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[OrganizationID] = " + perComID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowPerCom", tParameters, true).get(0);
    }

    default CrmPerCom crmInsPerCom(CrmPerCom crmPerCom) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComTitle", crmPerCom.getPerComTitle()));
        tParameters.add(new TParameter<>("PerComFName", crmPerCom.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", crmPerCom.getPerComLName()));
        tParameters.add(new TParameter<>("PerComAddress", crmPerCom.getPerComAddress()));
        tParameters.add(new TParameter<>("PerComMobile", crmPerCom.getPerComMobile()));
        tParameters.add(new TParameter<>("PerComPhone", crmPerCom.getPerComPhone()));
        tParameters.add(new TParameter<>("PerComTypeID", crmPerCom.getPerComTypeID()));
        tParameters.add(new TParameter<>("PerComWebsite", crmPerCom.getPerComWebsite()));
        tParameters.add(new TParameter<>("PerComEmail", crmPerCom.getPerComEmail()));
        tParameters.add(new TParameter<>("PerComDesc", crmPerCom.getPerComDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CRMInsPerCom", tParameters);
        return crmShowPerComByID(newID);
    }

    default CrmPerCom crmUpdPerCom(BigDecimal perComID, CrmPerCom crmPerCom) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComID", perComID));
        tParameters.add(new TParameter<>("PerComTitle", crmPerCom.getPerComTitle()));
        tParameters.add(new TParameter<>("PerComFName", crmPerCom.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", crmPerCom.getPerComLName()));
        tParameters.add(new TParameter<>("PerComAddress", crmPerCom.getPerComAddress()));
        tParameters.add(new TParameter<>("PerComMobile", crmPerCom.getPerComMobile()));
        tParameters.add(new TParameter<>("PerComPhone", crmPerCom.getPerComPhone()));
        tParameters.add(new TParameter<>("PerComTypeID", crmPerCom.getPerComTypeID()));
        tParameters.add(new TParameter<>("PerComWebsite", crmPerCom.getPerComWebsite()));
        tParameters.add(new TParameter<>("PerComEmail", crmPerCom.getPerComEmail()));
        tParameters.add(new TParameter<>("PerComDesc", crmPerCom.getPerComDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdPerCom", tParameters);
        return crmShowPerComByID(perComID);
    }

    default CrmPerCom CrmUpdOrganizationConversionToCustomer(BigDecimal perComID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComID", perComID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdOrganizationConversionToCustomer", tParameters);
        return crmShowPerComByID(perComID);
    }

    default void crmDelPerCom(BigDecimal perComID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComID", perComID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelPerCom", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "perComID", "perComID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "perComName", "نام", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComAddress", "ادرس", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComTypeDesc", "نوع شرکت", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComMobile", "تلفن همراه", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComPhone", "تلفن ثابت", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComWebsite", "وبسایت", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComEmail", "ایمیل", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "isConverted", "نوع مخاطب", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComDesc", "توضیحات", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        return new Meta(cols);
    }
}
