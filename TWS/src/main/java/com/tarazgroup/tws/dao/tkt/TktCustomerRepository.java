package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.routerParams.TRouterParamsOrganization;
import com.tarazgroup.tws.dto.tkt.routerParams.TRouterParamsUser;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktCustomer;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Icon;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
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
 * @date Jan-30, 2022
 ***/
public interface TktCustomerRepository extends TCrudRepository<TktCustomer>, CrudRepository<TktCustomer, BigDecimal> {
    default List<TktCustomer> tktShowCustomer(TktCustomer tktCustomer) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktCustomer._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktCustomer._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktCustomer._pageFilter()));
        return showSP("TktShowCustomer", tParameters, true);
    }

    default List<com.tarazgroup.tws.dto.tkt.customer.TktCustomer> tktShowCustomer1(TktCustomer tktCustomer) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktCustomer._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktCustomer._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktCustomer._pageFilter()));
        List<TktCustomer> tktCustomers = showSP("TktShowCustomer", tParameters, true);
        List<com.tarazgroup.tws.dto.tkt.customer.TktCustomer> __tktCustomers = new ArrayList<>();

        for (TktCustomer _tktCustomer : tktCustomers
        ) {
            com.tarazgroup.tws.dto.tkt.customer.TktCustomer __tktCustomer = new com.tarazgroup.tws.dto.tkt.customer.TktCustomer();
            __tktCustomer.setCustomerID(_tktCustomer.getCustomerID());
            __tktCustomer.setUserName(_tktCustomer.getUserName());
//            __tktCustomer.setOrganizationName(_tktCustomer.getOrganizationName());
            __tktCustomer.setOrganizationName(
                    new TRouter(_tktCustomer.getOrganizationName(),
                            "industry",
                            "organizations",
                            new TRouterParamsOrganization(null, _tktCustomer.getOrganizationName()),
                            null));
            __tktCustomer.setUserLoginName(_tktCustomer.getUserLoginName());
            __tktCustomer.setUserMobileNumber(_tktCustomer.getUserMobileNumber());
            __tktCustomer.setCustomerPhoneNumber(_tktCustomer.getCustomerPhoneNumber());
            __tktCustomer.setPriorityName(_tktCustomer.getPriorityName());
            __tktCustomer.setReceived(
                    new TRouter(_tktCustomer.getReceived().toString(),
                            "arrow-down",
                            "tickets",
                            new TRouterParamsUser(null, _tktCustomer.getCustomerID()),
                            null)
            );
            __tktCustomer.setSent(
                    new TRouter(_tktCustomer.getSent().toString(),
                            "arrow-up",
                            "tickets",
                            new TRouterParamsUser(_tktCustomer.getCustomerID(), null),
                            null)
            );
            __tktCustomers.add(__tktCustomer);
        }

        return __tktCustomers;
    }

    default TktCustomer tktShowCustomerByID(BigDecimal customerID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.CustomerID = " + customerID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowCustomer", tParameters, true).get(0);
    }

    default String md5Generator(String webUserPass) throws NoSuchAlgorithmException {
        MessageDigest m;
        m = MessageDigest.getInstance("MD5");
        byte[] data = webUserPass.getBytes(StandardCharsets.UTF_8);
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        return String.format("%1$032X", i);
    }

    default TktCustomer tktInsCustomer(TktCustomer tktCustomer) throws NoSuchAlgorithmException {
//        TktChangePassword tktChangePassword = new TktChangePassword();
        String hashedUserAndPassword = md5Generator(tktCustomer.getUserLoginName() + "$$$$" + tktCustomer.getAndroidUserPass());
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
//        tCalendar.setIranianDateBySlash(tktCustomer.getAccountExpirationDate());

//        accountExpirationDateG = tCalendar.getGregorianDateG();

        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComFName", tktCustomer.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", tktCustomer.getPerComLName()));
        tParameters.add(new TParameter<>("UserLoginName", tktCustomer.getUserLoginName()));
        tParameters.add(new TParameter<>("AndroidUserPass", tktCustomer.getAndroidUserPass()));
        tParameters.add(new TParameter<>("OrganizationalRank", tktCustomer.getOrganizationalRank()));
        tParameters.add(new TParameter<>("CustomerPhoneNumber", tktCustomer.getCustomerPhoneNumber()));
        tParameters.add(new TParameter<>("UserMobileNumber", tktCustomer.getUserMobileNumber()));

        tParameters.add(new TParameter<>("CustomerInternalNumber", tktCustomer.getCustomerInternalNumber()));
        tParameters.add(new TParameter<>("CustomerDesc", tktCustomer.getCustomerDesc()));

        if (tktCustomer.getAccountExpirationDate() == null) {
            tParameters.add(new TParameter<>("AccountExpirationDate", null));
        } else {
            tCalendar.setIranianDateBySlash(tktCustomer.getAccountExpirationDate());
            tParameters.add(new TParameter<>("AccountExpirationDate", tCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("PriorityID", tktCustomer.getPriorityID()));
        tParameters.add(new TParameter<>("IsOrganizationOwner", tktCustomer.getIsOrganizationOwner()));
        tParameters.add(new TParameter<>("IsNotActive", false));
        tParameters.add(new TParameter<>("OrganizationID", tktCustomer.getOrganizationID()));
        tParameters.add(new TParameter<>("AnyDeskID", tktCustomer.getAnyDeskID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsCustomer", tParameters);
        return tktShowCustomerByID(newID);
    }

    default TktCustomer tktUpdCustomer(BigDecimal perComID, TktCustomer tktCustomer) {

        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
//        tCalendar.setIranianDateBySlash(tktCustomer.getAccountExpirationDate());


        List<TParameter<?>> tParameters = new ArrayList<>();
        if (tktCustomer.getAccountExpirationDate() == null) {
            tParameters.add(new TParameter<>("AccountExpirationDate", null));
        } else {
            tCalendar.setIranianDateBySlash(tktCustomer.getAccountExpirationDate());
            tParameters.add(new TParameter<>("AccountExpirationDate", tCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("PerComID", perComID));
        tParameters.add(new TParameter<>("PerComFName", tktCustomer.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", tktCustomer.getPerComLName()));
        tParameters.add(new TParameter<>("UserLoginName", tktCustomer.getUserLoginName()));
        tParameters.add(new TParameter<>("UserMobileNumber", tktCustomer.getUserMobileNumber()));
//        tParameters.add(new TParameter<>("AndroidUserPass", tktCustomer.getAndroidUserPass()));
        tParameters.add(new TParameter<>("CustomerPhoneNumber", tktCustomer.getCustomerPhoneNumber()));
        tParameters.add(new TParameter<>("CustomerInternalNumber", tktCustomer.getCustomerInternalNumber()));
        tParameters.add(new TParameter<>("OrganizationalRank", tktCustomer.getOrganizationalRank()));
        tParameters.add(new TParameter<>("CustomerDesc", tktCustomer.getCustomerDesc()));
//        tParameters.add(new TParameter<>("AccountExpirationDate",tCalendar.getGregorianDate()));
        tParameters.add(new TParameter<>("PriorityID", tktCustomer.getPriorityID()));
        tParameters.add(new TParameter<>("IsOrganizationOwner", tktCustomer.getIsOrganizationOwner()));
        tParameters.add(new TParameter<>("IsNotActive", tktCustomer.getIsNotActive()));
        tParameters.add(new TParameter<>("OrganizationID", tktCustomer.getOrganizationID()));
        tParameters.add(new TParameter<>("AnyDeskID", tktCustomer.getAnyDeskID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdCustomer", tParameters);
        return tktShowCustomerByID(perComID);
    }

    default void tktDelCustomer(BigDecimal customerID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CustomerID", customerID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelCustomer", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "customerID", "customerID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "userName", "نام", Type.STRING, 200, true, true, true,Icon.none,false));
        cols.add(new Col(null, "organizationName", "سازمان", Type.ROUTER, 200, true, true,true,Icon.none, false));
        cols.add(new Col(null, "userLoginName", "ایمیل", Type.EMAIL, 250, true, true,false,Icon.none, false));
        cols.add(new Col(null, "userMobileNumber", "شماره موبایل", Type.STRING, 120, true, true,true,Icon.mobile, false));
        cols.add(new Col(null, "customerPhoneNumber", "تلفن ثابت", Type.STRING, 120, true, true,true,Icon.phone, false));
        cols.add(new Col(null, "received", "دریافتی", Type.ROUTER, 70, true, true, false, Icon.none,false));
        cols.add(new Col(null, "sent", "ارسالی", Type.ROUTER, 70, true, true, false, Icon.none,false));
        cols.add(new Col(null, "priorityName", "درجه اهمیت", Type.STRING, 100, true, true, false, Icon.none,false));

        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "customerID", "customerID", Type.DECIMAL, 0, false, false, false, Icon.none,true));
        cols.add(new Col(null, "perComFName", "*نام", Type.STRING, 100, true, true, false,Icon.none,false));
        cols.add(new Col(null, "perComLName", "*نام خانوادگی", Type.STRING, 100, true, true,false,Icon.none, false));
        cols.add(new Col(null, "userName", "نام", Type.STRING, 100, true, true,true,Icon.user, false));
        cols.add(new Col(null, "isOrganizationOwner", "سرپرست سازمان", Type.BOOLEAN, 100, true, true,false,Icon.none, false));
        cols.add(new Col(null, "isNotActive", "isNotActive", Type.BOOLEAN, 100, true, true,false,Icon.none, false));
        cols.add(new Col(null, "organizationID", "organizationID", Type.DECIMAL, 0, false, false,false,Icon.none, false));
        cols.add(new Col(null, "organizationName", "شرکت/سازمان", Type.STRING, 100, true, true,false,Icon.industry, false));
        cols.add(new Col(null, "userLoginName", "ایمیل", Type.STRING, 100, true, true,false,Icon.none, false));
        cols.add(new Col(null, "customerPhoneNumber", "تلفن ثابت", Type.STRING, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "priorityID", "priorityID", Type.DECIMAL, 0, false, false,false,Icon.phone, false));
        cols.add(new Col(null, "priorityName", "درجه اهمیت", Type.STRING, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "received", "دریافتی", Type.DECIMAL, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.DECIMAL, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "organizationalRank", "سمت سازمانی", Type.STRING, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "customerInternalNumber", "داخلی", Type.STRING, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "customerDesc", "توضیحات", Type.STRING, 200, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "accountExpirationDateG", "accountExpirationDateG", Type.DATE, 100, false, false, false,Icon.phone,false));
        cols.add(new Col(null, "accountExpirationDate", "تاریخ انقضاء اکانت", Type.STRING, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "androidUserPass", "کلمه عبور", Type.STRING, 100, true, true,false,Icon.phone, false));
        cols.add(new Col(null, "userMobileNumber", "شماره موبایل", Type.STRING, 100, true, true,true,Icon.mobile, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false,false,Icon.phone, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false,Icon.phone,false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false,Icon.phone,false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false,Icon.phone,false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false,Icon.phone,false));

        return new Meta(cols);
    }
}
