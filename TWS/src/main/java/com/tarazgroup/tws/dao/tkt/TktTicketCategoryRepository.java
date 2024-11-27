package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicketCategory;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Icon;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-24, 2022
 ***/
public interface TktTicketCategoryRepository extends TCrudRepository<TktTicketCategory>, CrudRepository<TktTicketCategory, BigDecimal> {
    default List<TktTicketCategory> tktShowTicketCategory(TktTicketCategory tktTicketCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        if (tktTicketCategory.getDepartmentID()==null) {
            tParameters.add(new TParameter<>("PageFilter", tktTicketCategory._pageFilter()));
        }
        else {
            if (tktTicketCategory.getDepartmentID().intValue() == 1) {
                tParameters.add(new TParameter<>("PageFilter", " AND DepartmentID = 1?,?"));
            } else if (tktTicketCategory.getDepartmentID().intValue() == 2) {
                tParameters.add(new TParameter<>("PageFilter", " AND DepartmentID = 2?,?"));
            } else{
                tParameters.add(new TParameter<>("PageFilter", tktTicketCategory._pageFilter()));
            }
        }
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicketCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicketCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("TktShowTicketCategory", tParameters, true);
    }

    default List<TktTicketCategory> tktShowTicketCategoryForGrid(TktTicketCategory tktTicketCategory) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicketCategory._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicketCategory._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " AND TicketCategoryName <> 'سایر'?,?"));
        return showSP("TktShowTicketCategory", tParameters, true);
    }

    default TktTicketCategory tktShowTicketCategoryByID(BigDecimal ticketCategoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " AND TicketCategoryID = " + ticketCategoryID+"?,?"));
        return showSP("TktShowTicketCategory", tParameters, true).get(0);
    }

    default TktTicketCategory tktShowTicketCategoryByIDForGrid(BigDecimal ticketCategoryID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketCategoryID = " + ticketCategoryID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " AND TicketCategoryName <> 'سایر'?,?"));
        return showSP("TktShowTicketCategory", tParameters, true).get(0);
    }

    default TktTicketCategory tktInsTicketCategory(TktTicketCategory tktTicketCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketCategoryName", tktTicketCategory.getTicketCategoryName()));
        tParameters.add(new TParameter<>("DepartmentID", tktTicketCategory.getDepartmentID()));
        tParameters.add(new TParameter<>("TicketLabelColor", tktTicketCategory.getTicketLabelColor()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsTicketCategory", tParameters);
        return tktShowTicketCategoryByID(newID);
    }

    default TktTicketCategory tktUpdTicketCategory(BigDecimal ticketCategoryID, TktTicketCategory tktTicketCategory) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketCategoryID", ticketCategoryID));
        tParameters.add(new TParameter<>("TicketCategoryName", tktTicketCategory.getTicketCategoryName()));
        tParameters.add(new TParameter<>("DepartmentID", tktTicketCategory.getDepartmentID()));
        tParameters.add(new TParameter<>("TicketLabelColor", tktTicketCategory.getTicketLabelColor()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdTicketCategory", tParameters);
        return tktShowTicketCategoryByID(ticketCategoryID);
    }

    default void  tktDelTicketCategory(BigDecimal ticketCategoryID){
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketCategoryID", ticketCategoryID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelTicketCategory", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "ticketCategoryID",   "ticketCategoryID", Type.DECIMAL, 0,   false, false,false, Icon.none, true ));
        cols.add(new Col(null, "departmentID",       "departmentID",     Type.DECIMAL, 0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "ticketLabelColor",   "",                 Type.COLOR,   50, true,  true,false, Icon.none,  false));
        cols.add(new Col(null, "ticketCategoryName", "عنوان",            Type.STRING,  100, true,  true,true, Icon.none,  false));
        cols.add(new Col(null, "departmentName",     "دپارتمان",         Type.STRING,  300, true,  true,true, Icon.industry, false));
        cols.add(new Col(null, "tickets",            "تیکت ها",          Type.DECIMAL, 100, true,  true,true, Icon.comment,  false));
        cols.add(new Col(null, "creatorID",          "creatorID",        Type.DECIMAL, 0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "createDate",         "createDate",       Type.DATE,    0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "modifierID",         "modifierID",       Type.DECIMAL, 0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "modifyDate",         "modifyDate",       Type.DATE,    0,   false, false,false, Icon.none, false));
        cols.add(new Col(null, "serverID",           "serverID",         Type.DECIMAL, 0,   false, false,false, Icon.none, false));

        return new Meta(cols);
    }
}
