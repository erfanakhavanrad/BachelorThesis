package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktDepartmentStaff;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-29, 2022
 ***/
public interface TktDepartmentStaffRepository extends TCrudRepository<TktDepartmentStaff>, CrudRepository<TktDepartmentStaff, BigDecimal> {
    default List<TktDepartmentStaff> tktShowDepartmentStaff(TktDepartmentStaff tktDepartmentStaff) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktDepartmentStaff._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktDepartmentStaff._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktDepartmentStaff._pageFilter()));
        tParameters.add(new TParameter<>("OrgType", null));
        return showSP("TktShowDepartmentStaff", tParameters, true);
    }

    default TktDepartmentStaff tktShowDepartmentStaffByID(BigDecimal departmentStaffID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.DepartmentStaffID = " + departmentStaffID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowDepartmentStaff", tParameters, true).get(0);
    }

    default TktDepartmentStaff tktInsDepartmentStaff(TktDepartmentStaff tktDepartmentStaff) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("DepartmentID", tktDepartmentStaff.getDepartmentID()));
        tParameters.add(new TParameter<>("UserID", tktDepartmentStaff.getUserID()));
        tParameters.add(new TParameter<>("IsOwner", tktDepartmentStaff.getIsOwner()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsDepartmentStaff", tParameters);
        return tktShowDepartmentStaffByID(newID);
    }

    default  TktDepartmentStaff tktUpdDepartmentStaff(BigDecimal departmentStaffID, TktDepartmentStaff tktDepartmentStaff) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("DepartmentStaffID", departmentStaffID));
        tParameters.add(new TParameter<>("DepartmentID", tktDepartmentStaff.getDepartmentID()));
        tParameters.add(new TParameter<>("UserID", tktDepartmentStaff.getUserID()));
        tParameters.add(new TParameter<>("IsOwner", tktDepartmentStaff.getIsOwner()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdDepartmentStaff", tParameters);
        return tktShowDepartmentStaffByID(departmentStaffID);
    }

    default void tktDelDepartmentStaff(BigDecimal departmentStaffID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("DepartmentStaffID", departmentStaffID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelDepartmentStaff", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "departmentStaffID", "departmentStaffID",     Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "departmentID",      "departmentID",          Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "departmentName",    "عنوان",                 Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "userID",            "userID",                Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "uName",             "کاربر",                   Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "isOwner",           "isOwner",               Type.BOOLEAN, 100, false, false, false));
        cols.add(new Col(null, "inProgress",        "در حال بررسی",          Type.DECIMAL, 100, true,  true,  false));
        cols.add(new Col(null, "answered",          "پاسخ داده شده",         Type.DECIMAL, 100, true,  true,  false));
        cols.add(new Col(null, "founderAnswer",     "پاسخ ایجاد کننده تیکت", Type.DECIMAL, 100, true,  true,  false));
        cols.add(new Col(null, "closed",            "بسته شده",              Type.DECIMAL, 100, true,  true,  false));
        cols.add(new Col(null, "received",          "دریافتی",               Type.DECIMAL, 100, true,  true,  false));
        cols.add(new Col(null, "sent",              "ارسالی",                Type.DECIMAL, 100, true,  true,  false));
        cols.add(new Col(null, "serverID",          "serverID",              Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",        "createDate",            Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "creatorID",         "creatorID",             Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",        "modifyDate",            Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",        "modifierID",            Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
