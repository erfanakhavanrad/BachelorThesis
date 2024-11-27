package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktStaffRole;
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
 * @date Jan-27, 2022
 ***/
public interface TktStaffRoleRepository extends TCrudRepository<TktStaffRole>, CrudRepository<TktStaffRole, BigDecimal> {

    default List<TktStaffRole> tktShowStaffRole(TktStaffRole tktStaffRole) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktStaffRole._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktStaffRole._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktStaffRole._pageFilter()));
        return showSP("TktShowStaffRole", tParameters, true);
    }

    default TktStaffRole tktShowStaffRoleByID(BigDecimal staffRoleID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.StaffRoleID = " + staffRoleID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowStaffRole", tParameters, true).get(0);
    }

    default List<TktStaffRole> tktShowStaffRoleByStaffID(BigDecimal staffID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.StaffID = " + staffID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowStaffRole", tParameters, false);
    }

    default TktStaffRole tktInsStaffRole(TktStaffRole tktStaffRole) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StaffID", tktStaffRole.getStaffID()));
        tParameters.add(new TParameter<>("RoleID", tktStaffRole.getRoleID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        BigDecimal newID = insSP("TktInsStaffRole", tParameters);
        return tktShowStaffRoleByID(newID);
    }

    default void tktDelStaffRole(BigDecimal staffRoleID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StaffRoleID", staffRoleID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelStaffRole", tParameters);
    }

    default TktStaffRole tktUpdStaffRole(BigDecimal staffRoleID, TktStaffRole tktStaffRole) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StaffRoleID", staffRoleID));
        tParameters.add(new TParameter<>("RoleID", tktStaffRole.getRoleID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdStaffRole", tParameters);
        return tktShowStaffRoleByID(staffRoleID);

    }


    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "staffRoleID", "staffRoleID",     Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "roleID",      "roleID",          Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "roleName",    "نقش در دپارتمان", Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "staffID",     "staffID",         Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "perComFName", "perComFName",     Type.STRING,  100, false, false, false));
        cols.add(new Col(null, "perComLName", "perComLName",     Type.STRING,  100, false, false, false));
        cols.add(new Col(null, "creatorID",   "creatorID",       Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",  "createDate",      Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",  "modifierID",      Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",  "modifyDate",      Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",    "serverID",        Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
