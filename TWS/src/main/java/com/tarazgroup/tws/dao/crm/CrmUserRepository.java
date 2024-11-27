package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dao.tkt.TktStaffRoleRepository;
import com.tarazgroup.tws.model.crm.CrmStatus;
import com.tarazgroup.tws.model.crm.CrmUser;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktStaffRole;
import com.tarazgroup.tws.model.tkt.TktUser;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-11, 2023
 ***/
public interface CrmUserRepository extends TCrudRepository<CrmUser>, CrudRepository<CrmUser, BigDecimal> {

    default List<CrmUser> crmShowUser(CrmUser crmUser) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmUser._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmUser._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmUser._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowUser", tParameters, true);
    }

    default List<CrmUser> crmShowStaff(CrmUser crmUser) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And Main.IsCustomer = 0"));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmUser._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmUser._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmUser._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowUser", tParameters, true);
    }


    //    GET BY ID
    default CrmUser crmShowUserByID(BigDecimal userID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.UserID=" + userID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowUser", tParameters, true).get(0);
    }
    default CrmUser crmUpdProfile(BigDecimal userID, CrmUser crmUser) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("PerComFName", crmUser.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", crmUser.getPerComLName()));
        tParameters.add(new TParameter<>("UserLoginName", crmUser.getUserLoginName()));
        tParameters.add(new TParameter<>("AndroidUserPass", crmUser.getAndroidUserPass()));
        tParameters.add(new TParameter<>("Username", crmUser.getUsername()));
        tParameters.add(new TParameter<>("IsCustomer", crmUser.getIsCustomer()));
        tParameters.add(new TParameter<>("UserMobileNumber", crmUser.getUserMobileNumber()));
        tParameters.add(new TParameter<>("ActiveYearID", crmUser.getActiveYearID()));
        tParameters.add(new TParameter<>("VoucherThemeID", crmUser.getVoucherThemeID()));
        tParameters.add(new TParameter<>("UserInternalNumber", crmUser.getUserInternalNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdProfile", tParameters);
        return crmShowUserByID(userID);
    }
    //   staff POST
    default CrmUser crmInsStaff(CrmUser crmUser, TktStaffRoleRepository tktStaffRoleRepository) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComFName", crmUser.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", crmUser.getPerComLName()));
        tParameters.add(new TParameter<>("UserLoginName", crmUser.getUserLoginName()));
        tParameters.add(new TParameter<>("AndroidUserPass", crmUser.getAndroidUserPass()));
        tParameters.add(new TParameter<>("IsCustomer", crmUser.getIsCustomer()));
        tParameters.add(new TParameter<>("UserMobileNumber", crmUser.getUserMobileNumber()));
        tParameters.add(new TParameter<>("UserInternalNumber", crmUser.getUserInternalNumber()));
        tParameters.add(new TParameter<>("OrganizationalRank", null));
        tParameters.add(new TParameter<>("UserDesc", null));
        tParameters.add(new TParameter<>("AccountExpirationDateG", null));
        tParameters.add(new TParameter<>("PriorityID", null));
        tParameters.add(new TParameter<>("IsOrganizationOwner", null));
        tParameters.add(new TParameter<>("OrganizationID", null));
        tParameters.add(new TParameter<>("HasAccessSendTicketToCustomer", crmUser.getHasAccessSendTicketToCustomer()));
        tParameters.add(new TParameter<>("HasAccessToCustomerInfo", crmUser.getHasAccessToCustomerInfo()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CRMInsUser", tParameters);

        for (int i = 0; i < crmUser.getRoles().length; i++) {
            TktStaffRole tktStaffRole = new TktStaffRole();
            tktStaffRole.setStaffID(newID);
            tktStaffRole.setRoleID(crmUser.getRoles()[i]);
            tktStaffRoleRepository.tktInsStaffRole(tktStaffRole);
        }

        return crmShowUserByID(newID);
    }

    //   customer POST
    default CrmUser crmInsCustomer(CrmUser crmUser) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComFName", crmUser.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", crmUser.getPerComLName()));
        tParameters.add(new TParameter<>("UserLoginName", crmUser.getUserLoginName()));
        tParameters.add(new TParameter<>("AndroidUserPass", crmUser.getAndroidUserPass()));
        tParameters.add(new TParameter<>("IsCustomer", crmUser.getIsCustomer()));
        tParameters.add(new TParameter<>("UserMobileNumber", crmUser.getUserMobileNumber()));
        tParameters.add(new TParameter<>("UserInternalNumber", crmUser.getUserInternalNumber()));
        tParameters.add(new TParameter<>("OrganizationalRank", crmUser.getOrganizationalRank()));
        tParameters.add(new TParameter<>("UserDesc", crmUser.getUserDesc()));
        tParameters.add(new TParameter<>("AccountExpirationDateG", crmUser.getAccountExpirationDateG()));
        tParameters.add(new TParameter<>("PriorityID", crmUser.getPriorityID()));
        tParameters.add(new TParameter<>("IsOrganizationOwner", crmUser.getIsOrganizationOwner()));
        tParameters.add(new TParameter<>("OrganizationID", crmUser.getOrganizationID()));
        tParameters.add(new TParameter<>("HasAccessSendTicketToCustomer", null));
        tParameters.add(new TParameter<>("HasAccessToCustomerInfo", null));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CRMInsUser", tParameters);
        return crmShowUserByID(newID);
    }

    default CrmUser crmUpdLotteryWinner(BigDecimal userID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdLotteryWinner", tParameters);
        return crmShowUserByID(userID);
    }

    default void crmDelWinners() {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdClearLottery", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "perComName", "نام", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userLoginName", "نام کاربری", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userMobileNumber", "موبایل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userInternalNumber", "داخلی", Type.STRING, 70, true, true, false));
        return new Meta(cols);
    }

}
