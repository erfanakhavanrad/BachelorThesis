package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmCalendarCategory;
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
 * @date 2/27/23
 */
public interface CrmCalendarCategoryRepository extends TCrudRepository<CrmCalendarCategory>, CrudRepository<CrmCalendarCategory, BigDecimal> {

    default List<CrmCalendarCategory> crmShowCalendarCategory(CrmCalendarCategory crmCalendarCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmCalendarCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmCalendarCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmCalendarCategory._pageFilter()));
        return showSP("CrmShowCalendarCategory", tParameters, true);
    }
    default CrmCalendarCategory crmShowCalendarCategoryByID(BigDecimal calendarCategoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[CalendarCategoryID]=" + calendarCategoryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowCalendarCategory", tParameters, true).get(0);
    }

    //    POST
    default CrmCalendarCategory crmInsCalendarCategory(CrmCalendarCategory crmCalendarCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Title", crmCalendarCategory.getTitle()));
        tParameters.add(new TParameter<>("Color", crmCalendarCategory.getColor()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsCalendarCategory", tParameters);
        return crmShowCalendarCategoryByID(newID);
    }
    //  PUT
    default CrmCalendarCategory crmUpdCalendarCategory(BigDecimal calendarCategoryID, CrmCalendarCategory crmCalendarCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CalendarCategoryID", calendarCategoryID));
        tParameters.add(new TParameter<>("Title", crmCalendarCategory.getTitle()));
        tParameters.add(new TParameter<>("Color", crmCalendarCategory.getColor()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdCalendarCategory", tParameters);
        return crmShowCalendarCategoryByID(calendarCategoryID);
    }

    //DELETE
    default void crmDelCalendarCategory(BigDecimal calendarCategoryID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CalendarCategoryID", calendarCategoryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelCalendarCategory", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "calendarCategoryID", "calendarCategoryID", Type.DECIMAL,false, 0, false, false, true));
        cols.add(new Col(null, "title", "عنوان", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "color", "color", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL,false, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, false,0, false, false, false));
        return new Meta(cols);
    }
}
