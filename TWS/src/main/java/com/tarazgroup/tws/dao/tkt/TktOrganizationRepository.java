package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.routerParams.TRouterParamsOrganization;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktOrganization;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-30, 2022
 ***/
public interface TktOrganizationRepository extends TCrudRepository<TktOrganization>, CrudRepository<TktOrganization, BigDecimal> {

//    default List<TktOrganization> tktShowOrganization1(TktOrganization tktOrganization) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", tktOrganization._serverFilter()));
//        tParameters.add(new TParameter<>("YearFilter", tktOrganization._yearFilter()));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", tktOrganization._pageFilter()));
//        return showSP("TktShowOrganization", tParameters, true);
//    }

    default List<com.tarazgroup.tws.dto.tkt.organization.TktOrganization> tktShowOrganization(TktOrganization tktOrganization) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktOrganization._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktOrganization._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktOrganization._pageFilter()));
        List<TktOrganization> tktOrganizations = showSP("TktShowOrganization", tParameters, true);
        List<com.tarazgroup.tws.dto.tkt.organization.TktOrganization> __tktOrganizations = new ArrayList<>();

        for (TktOrganization _tktOrganization : tktOrganizations
        ) {
            com.tarazgroup.tws.dto.tkt.organization.TktOrganization __tktOrganization = new com.tarazgroup.tws.dto.tkt.organization.TktOrganization();
            __tktOrganization.setOrganizationID(_tktOrganization.getOrganizationID());
            __tktOrganization.setOrganizationName(_tktOrganization.getOrganizationName());
            __tktOrganization.setOrganizationPhoneNumber(_tktOrganization.getOrganizationPhoneNumber());
            __tktOrganization.setUsers(
                    new TRouter(_tktOrganization.getUsers().toString(),
                            "users",
                            "customers",
                            new TRouterParamsOrganization(_tktOrganization.getOrganizationID(),null),
                            null)
            );// منظور تعداد کاربران است
            __tktOrganization.setExpirationDate(_tktOrganization.getExpirationDate());
            __tktOrganization.setOrganizationWebsite(_tktOrganization.getOrganizationWebsite());
            __tktOrganization.setPriorityName(_tktOrganization.getPriorityName());
            __tktOrganization.setSent(
                    new TRouter(_tktOrganization.getSent().toString(),
                            "arrow-up",
                            "tickets",
                            new TRouterParamsOrganization(_tktOrganization.getOrganizationID(),null),
                            null)
            );
            __tktOrganization.setReceived(
                    new TRouter(_tktOrganization.getReceived().toString(),
                            "arrow-down",
                            "tickets",
                            new TRouterParamsOrganization(_tktOrganization.getOrganizationID(),null),
                            null)
            );
            __tktOrganizations.add(__tktOrganization);
        }

        return __tktOrganizations;
    }

    default TktOrganization tktShowOrganizationByID(BigDecimal organizationID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.OrganizationID = " + organizationID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowOrganization", tParameters, true).get(0);
    }

    default TktOrganization tktInsOrganization(TktOrganization tktOrganization) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();


        List<TParameter<?>> tParameters = new ArrayList<>();
        if (tktOrganization.getExpirationDate() == null) {
            tParameters.add(new TParameter<>("ExpirationDate", null));
        } else {
            tCalendar.setIranianDateBySlash(tktOrganization.getExpirationDate());
            tParameters.add(new TParameter<>("ExpirationDate", tCalendar.getGregorianDate()));
        }

        tParameters.add(new TParameter<>("PerComTitle", tktOrganization.getPerComTitle()));
        tParameters.add(new TParameter<>("PerComName", tktOrganization.getPerComName()));
        tParameters.add(new TParameter<>("OrganizationAddress", tktOrganization.getOrganizationAddress()));
        tParameters.add(new TParameter<>("OrganizationPhoneNumber", tktOrganization.getOrganizationPhoneNumber()));
        tParameters.add(new TParameter<>("OrganizationWebsite", tktOrganization.getOrganizationWebsite()));
        tParameters.add(new TParameter<>("OrganizationDesc", tktOrganization.getOrganizationDesc()));
        tParameters.add(new TParameter<>("PriorityID", tktOrganization.getPriorityID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsOrganization", tParameters);
        return tktShowOrganizationByID(newID);
    }

    default TktOrganization tktUpdOrganization(BigDecimal organizationID, TktOrganization tktOrganization) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
//        tCalendar.setIranianDateBySlash(tktOrganization.getExpirationDate());

        List<TParameter<?>> tParameters = new ArrayList<>();
        if (tktOrganization.getExpirationDate() == null) {
            tParameters.add(new TParameter<>("ExpirationDate", null));
        } else {
            tCalendar.setIranianDateBySlash(tktOrganization.getExpirationDate());
            tParameters.add(new TParameter<>("ExpirationDate", tCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("OrganizationID", organizationID));
        tParameters.add(new TParameter<>("PerComTitle", tktOrganization.getPerComTitle()));
        tParameters.add(new TParameter<>("PerComName", tktOrganization.getPerComName()));
        tParameters.add(new TParameter<>("OrganizationAddress", tktOrganization.getOrganizationAddress()));
        tParameters.add(new TParameter<>("OrganizationPhoneNumber", tktOrganization.getOrganizationPhoneNumber()));
        tParameters.add(new TParameter<>("OrganizationWebsite", tktOrganization.getOrganizationWebsite()));
        tParameters.add(new TParameter<>("OrganizationDesc", tktOrganization.getOrganizationDesc()));
//        tParameters.add(new TParameter<>("ExpirationDate", tCalendar.getGregorianDate()));
        tParameters.add(new TParameter<>("PriorityID", tktOrganization.getPriorityID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdOrganization", tParameters);
        return tktShowOrganizationByID(organizationID);
    }

    default void tktDelOrganization(BigDecimal organizationID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("OrganizationID", organizationID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelOrganization", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "organizationID", "organizationID", Type.DECIMAL, 0, false, true,false, Icon.none, true));
        cols.add(new Col(null, "organizationName", "عنوان", Type.STRING, 140, true, true,true,Icon.none, false));
        cols.add(new Col(null, "perComTitle", "perComTitle", Type.STRING, 140, false, true,true,Icon.none, false));
        cols.add(new Col(null, "perComName", "perComName", Type.STRING, 140, false, true,true,Icon.none, false));
        cols.add(new Col(null, "organizationWebsite", "وب سایت", Type.LINK, 270, true, true,true,Icon.link, false));
        cols.add(new Col(null, "organizationPhoneNumber", "تلفن ثابت", Type.STRING, 120, true, true,true,Icon.phone_square, false));
        cols.add(new Col(null, "users", "کاربران", Type.ROUTER, 100, true, true,false,Icon.none, false));
        cols.add(new Col(null, "received", "دریافتی", Type.ROUTER, 70, true, true,false,Icon.none, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.ROUTER, 70, true, true,false,Icon.none, false));
        cols.add(new Col(null, "expirationDate", "اتمام دسترسی", Type.STRING, 110, true, true,false,Icon.none, false));
        cols.add(new Col(null, "priorityName", "درجه اهمیت", Type.STRING, 100, true, true,false,Icon.none, false));

        return new Meta(cols);
    }

    default Meta metaTemp() {
        // این متد بخاطر این بوده است که تیکت های دریافتی و ارسالی رو یک ستون در نظر گرفته بودیم
        // که دیگر کاربرد ندارد
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "organizationID", "organizationID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "organizationName", "عنوان", Type.STRING, 140, true, true, false));
        cols.add(new Col(null, "organizationWebsite", "وب سایت", Type.LINK, 270, true, true, false));
        cols.add(new Col(null, "organizationPhoneNumber", "تلفن ثابت", Type.STRING, 120, true, true, false));
        cols.add(new Col(null, "users", "کاربران", Type.ROUTER, 100, true, true, false));

        List<Info> infosTicketSentReceived = new ArrayList<>();
        Info infoSend = new Info("send", "تیکت ارسالی", "secondary");
        Info infoReceived = new Info("received", "تیکت دریافتی", "secondary");
        infosTicketSentReceived.add(infoSend);
        infosTicketSentReceived.add(infoReceived);
        cols.add(new Col(null, "ticketSentReceived", "دریافتی/ارسالی", Type.OBJECT, 240, true, true, infosTicketSentReceived,false,Icon.none, false));
        cols.add(new Col(null, "expirationDate", "اتمام دسترسی", Type.STRING, 110, true, true, false));
        cols.add(new Col(null, "priorityName", "درجه اهمیت", Type.STRING, 100, true, true, false));

        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "organizationID", "organizationID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "organizationName", "عنوان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "organizationAddress", "آدرس", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "organizationPhoneNumber", "تلفن ثابت", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "organizationWebsite", "وب سایت", Type.LINK, 100, true, true, false));
        cols.add(new Col(null, "organizationDesc", "توضیحات", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "expirationDate", "اتمام دسترسی", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "expirationDateG", "expirationDateG", Type.DATE, 100, true, true, false));
        cols.add(new Col(null, "users", "کاربران", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "received", "دریافتی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "priorityID", "priorityID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "priorityName", "درجه اهمیت", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));

        return new Meta(cols);
    }
}
