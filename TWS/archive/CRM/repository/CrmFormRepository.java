package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.pub.PubUsersRepository;
import com.tarazgroup.tws.model.acc.AccBank;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.crm.CrmFormsSystem;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubUsers;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmFormRepository extends TCrudRepository<CrmForm>, CrudRepository<CrmForm, BigDecimal> {

    default int recordsCount(Map<String, String> params) {
        CrmForm crmForm = setParams(CrmForm.class, params);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmForm._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmForm._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmForm._pageFilter()));
        return showSP("CrmShowForm", tParameters, true).size();
    }

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

    default InputStreamResource excel(CrmForm crmForm) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmForm._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmForm._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmForm._pageFilter()));
        List<CrmForm> rows = showSP("CrmShowForm", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default List<CrmForm> crmShowFormsUser(PubUsersRepository pubUsersRepository) {
        // لیست فرم های سفارشی که کاربر ساخته است
        // منظور فرصت کمپین مشتری تیکت نیست
        LogLogins logLogins = fetchUserDetail();
        PubUsers pubUsers = pubUsersRepository.pubShowUsersByID(logLogins.getPubUser().getUserID());
        BigDecimal serverID = pubUsers.getDefaultServerID();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.ServerID = " + serverID + " AND Main.CanDelete=1"));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowForm", tParameters, false);
    }

    default CrmFormsSystem crmShowFormsSystem(PubUsersRepository pubUsersRepository) {
        // مناسب برای زمانی که منوهای ‍ ÷ فرم های سفارشی ÷ ساخته میشود
        LogLogins logLogins = fetchUserDetail();
        PubUsers pubUsers = pubUsersRepository.pubShowUsersByID(logLogins.getPubUser().getUserID());
        BigDecimal serverID = pubUsers.getDefaultServerID();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.ServerID = " + serverID + " AND Main.CanDelete=0"));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        List<CrmForm> crmForms = showSP("CrmShowForm", tParameters, false);
        CrmFormsSystem crmFormsSystem = new CrmFormsSystem();
        crmFormsSystem.setDataSourse(crmForms);
        return crmFormsSystem;
    }

    default CrmForm crmInsForm(CrmForm crmForm) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormName", crmForm.getFormName()));
        tParameters.add(new TParameter<>("TableName", crmForm.getTableName()));
        tParameters.add(new TParameter<>("FormLatinName", crmForm.getFormLatinName()));
        tParameters.add(new TParameter<>("DataEntryHeight", crmForm.getDataEntryHeight()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsForm", tParameters);
        return crmShowFormByID(newID);
    }

    default void crmDelForm(BigDecimal formID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelForm", tParameters);
    }

    default CrmForm crmUpdForm(BigDecimal formID, CrmForm crmForm) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("FormName", crmForm.getFormName()));
        tParameters.add(new TParameter<>("TableName", crmForm.getTableName()));
        tParameters.add(new TParameter<>("FormLatinName", crmForm.getFormLatinName()));
        tParameters.add(new TParameter<>("DataEntryHeight", crmForm.getDataEntryHeight()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdForm", tParameters);
        return crmShowFormByID(formID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "formID", "formID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "formName", "نام فرم", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "tableName", "نام جدول", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "formLatinName", "نام لاتین فرم", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "dataEntryHeight", "ارتفاع پنل ورود اطلاعات", Type.INTEGER, 200, true, true, false));
        cols.add(new Col(null, "canDelete", "فرم کاربر", Type.BOOLEAN, 100, true, true, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        return new Meta(cols);
    }
}
