package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 8/20/22
 *
 * @author Erfan Akhavan
 */
public interface CrmFormRepository extends TCrudRepository<CrmForm>, CrudRepository<CrmForm, BigDecimal> {

    //    GET All
    default List<CrmForm> crmShowForm(CrmForm crmForm) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmForm._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmForm._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmForm._pageFilter()));
        return showSP("CrmShowForm", tParameters, true);
    }

    //    GET BY ID
    default CrmForm crmShowFormByID(BigDecimal formID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.formID=" + formID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowForm", tParameters, true).get(0);
    }

    //    POST
    default CrmForm crmInsForm(CrmForm crmForm) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("FormName", crmForm.getFormName()));
        tParameters.add(new TParameter("TableName", null));
        tParameters.add(new TParameter("FormLatinName", crmForm.getFormLatinName()));
        tParameters.add(new TParameter("DataEntryHeight", crmForm.getDataEntryHeight()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsForm", tParameters);
        return crmShowFormByID(newID);
    }


    default CrmForm crmUpdForm(BigDecimal formID, CrmForm crmForm) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("FormName", crmForm.getFormName()));
        tParameters.add(new TParameter<>("TableName", null));
        tParameters.add(new TParameter<>("FormLatinName", crmForm.getFormLatinName()));
        tParameters.add(new TParameter<>("DataEntryHeight", crmForm.getDataEntryHeight()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdForm", tParameters);
        return crmShowFormByID(formID);
    }

    //    DELETE
    default void crmDelForm(BigDecimal formID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSPNew("CrmDelForm", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "formID", "ایدی فرم", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "buttonID", "buttonID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "formName", "نام فرم", Type.STRING, 0, true, true, false));
        cols.add(new Col(null, "tableName", "tableName", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "formLatinName", "نام فرم به لاتین", Type.STRING, 300, true, true, false));
        cols.add(new Col(null, "dataEntryHeight", "dataEntryHeight", Type.INTEGER, 0, false, false, false));
        cols.add(new Col(null, "canDelete", "قابلیت حذف شدن", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }


}
