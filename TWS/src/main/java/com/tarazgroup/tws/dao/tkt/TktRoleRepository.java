package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktRole;
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
 * @date Jan-23, 2022
 ***/
public interface TktRoleRepository extends TCrudRepository<TktRole>, CrudRepository<TktRole, BigDecimal> {
    default List<TktRole> tktShowRole(TktRole tktRole) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktRole._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktRole._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktRole._pageFilter()));
        return showSP("TktShowRole", tParameters,true);
    }

    default TktRole tktShowRoleByID(BigDecimal roleID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.RoleID = " + roleID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowRole", tParameters,true).get(0);
    }

    default  TktRole tktInsRole(TktRole tktRole) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RoleName", tktRole.getRoleName()));
        tParameters.add(new TParameter<>("IsOwner", tktRole.getIsOwner()));
        tParameters.add(new TParameter<>("DepartmentID", tktRole.getDepartmentID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsRole", tParameters);
        return tktShowRoleByID(newID);
    }

    default TktRole tktUpdRole(BigDecimal roleID, TktRole tktRole) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RoleID", roleID));
        tParameters.add(new TParameter<>("RoleName", tktRole.getRoleName()));
        tParameters.add(new TParameter<>("IsOwner", tktRole.getIsOwner()));
        tParameters.add(new TParameter<>("DepartmentID", tktRole.getDepartmentID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdRole", tParameters);
        return tktShowRoleByID(roleID);
    }

    default void tktDelRole(BigDecimal roleID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RoleID", roleID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelRole", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "roleID",     "roleID",     Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "roleName",   "نقش",        Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "departmentID",  "departmentID",  Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "isOwner",  "isOwner",  Type.BOOLEAN, 0,   false, false, false));
        cols.add(new Col(null, "creatorID",  "creatorID",  Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",   "serverID",   Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }

}
