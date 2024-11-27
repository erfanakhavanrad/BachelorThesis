package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.TktDepartmentDto;
import com.tarazgroup.tws.dto.tkt.department.TicketStatus;
import com.tarazgroup.tws.dto.tkt.routerParams.TRouterParamsDepartment;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktDepartment;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.*;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-24, 2022
 ***/
public interface TktDepartmentRepository extends TCrudRepository<TktDepartment>, CrudRepository<TktDepartment, BigDecimal> {
    default List<TktDepartment> tktShowDepartment(TktDepartment tktDepartment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktDepartment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktDepartment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktDepartment._pageFilter()));
        return showSP("TktShowDepartment", tParameters, true);
    }

    default List<TktDepartment> tktShowUserDepartment(BigDecimal userID, Boolean isOwner) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("IsOwner", isOwner));
        return showSP("TktShowUserDepartment", tParameters, true);
    }

    default List<com.tarazgroup.tws.dto.tkt.department.TktDepartment> tktShowDepartment1(TktDepartment tktDepartment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktDepartment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktDepartment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktDepartment._pageFilter()));
        List<TktDepartment> tktDepartments = showSP("TktShowDepartment", tParameters, true);
        List<com.tarazgroup.tws.dto.tkt.department.TktDepartment> __tktDepartments = new ArrayList<>();

        for (TktDepartment _tktDepartment : tktDepartments
        ) {
            com.tarazgroup.tws.dto.tkt.department.TktDepartment __tktDepartment = new com.tarazgroup.tws.dto.tkt.department.TktDepartment();
            __tktDepartment.setDepartmentID(_tktDepartment.getDepartmentID());
            __tktDepartment.setDepartmentName(_tktDepartment.getDepartmentName());
            __tktDepartment.setDepartmentEmailAddress(_tktDepartment.getDepartmentEmailAddress());
            __tktDepartment.setIsVisibleForCustomers(_tktDepartment.getIsVisibleForCustomers());
            __tktDepartment.setOwners(_tktDepartment.getOwners());
            TicketStatus ticketStatus = new TicketStatus();
            ticketStatus.setOpen(_tktDepartment.getOpen());
            ticketStatus.setInProgress(_tktDepartment.getInProgress());
            ticketStatus.setAnswered(_tktDepartment.getAnswered());
            ticketStatus.setFounderAnswer(_tktDepartment.getFounderAnswer());
            ticketStatus.setClosed(_tktDepartment.getClosed());
            __tktDepartment.setTicketStatus(ticketStatus);
            __tktDepartment.setReceived(
                    new TRouter(_tktDepartment.getReceived().toString(),
                            "arrow-down",
                            "tickets",
                            new TRouterParamsDepartment(null, _tktDepartment.getDepartmentID()),
                            null)
            );
            __tktDepartment.setSent(
                    new TRouter(_tktDepartment.getSent().toString(),
                            "arrow-up",
                            "tickets",
                            new TRouterParamsDepartment(_tktDepartment.getDepartmentID(), null),
                            null));
            __tktDepartments.add(__tktDepartment);
        }

        return __tktDepartments;
    }

    default TktDepartment tktShowDepartmentByID(BigDecimal departmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.DepartmentID = " + departmentID));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowDepartment", tParameters, true).get(0);
    }

    default TktDepartment tktInsDepartment(TktDepartmentDto tktDepartmentDto) {
        LogLogins logLogins = fetchUserDetail();
//        TCalendar tCalendar = new TCalendar();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("DepartmentName", tktDepartmentDto.getDepartmentName()));
        tParameters.add(new TParameter<>("DepartmentEmailAddress", tktDepartmentDto.getDepartmentEmailAddress()));
        tParameters.add(new TParameter<>("IsVisibleForCustomers", tktDepartmentDto.getIsVisibleForCustomers()));
        tParameters.add(new TParameter<>("TicketTimeout", tktDepartmentDto.getTicketTimeout()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsDepartment", tParameters);
        return tktShowDepartmentByID(newID);
    }

    default TktDepartment tktUpdDepartment(BigDecimal departmentID, TktDepartmentDto tktDepartmentDto) {
        LogLogins logLogins = fetchUserDetail();
//        TCalendar tCalendar = new TCalendar();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("DepartmentID", departmentID));
        tParameters.add(new TParameter<>("DepartmentName", tktDepartmentDto.getDepartmentName()));
        tParameters.add(new TParameter<>("DepartmentEmailAddress", tktDepartmentDto.getDepartmentEmailAddress()));
        tParameters.add(new TParameter<>("IsVisibleForCustomers", tktDepartmentDto.getIsVisibleForCustomers()));
        tParameters.add(new TParameter<>("TicketTimeout", tktDepartmentDto.getTicketTimeout()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdDepartment", tParameters);
        return tktShowDepartmentByID(departmentID);
    }

    default void tktDelDepartment(BigDecimal departmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("DepartmentID", departmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelDepartment", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "departmentID", "departmentID", Type.DECIMAL, 0, false, false,false, Icon.none, true));
        cols.add(new Col(null, "departmentName", "عنوان", Type.STRING, 200, true, true, true, Icon.none,false));
        cols.add(new Col(null, "owners", "سرپرستان", Type.STRING, 300, true, true,false, Icon.user, false));
        cols.add(new Col(null, "departmentEmailAddress", "ایمیل", Type.EMAIL, 250, true, true,true, Icon.envelope, false));
        cols.add(new Col(null, "isVisibleForCustomers", "نمایش برای مشتری", Type.BOOLEAN, 130, false, false,false, Icon.none, false));
//        cols.add(new Col(null, "ticketTimeout", "مهلت پیش فرض بسته شدن تیکت", Type.DATE, 230, true, true, false));
        List<Info> infosTicketStatus = new ArrayList<>();
        Info infoOpen = new Info("open", "باز", "warning");
        Info infoInProgress = new Info("inProgress", "در حال بررسی", "danger");
        Info infoAnswered = new Info("answered", "پاسخ داده شده", "info");
        Info infoFounderAnswer = new Info("founderAnswer", "پاسخ ایجاد کننده تیکت", "success");
        Info infoClosed = new Info("closed", "بسته شده", "primary");
        infosTicketStatus.add(infoOpen);
        infosTicketStatus.add(infoInProgress);
        infosTicketStatus.add(infoAnswered);
        infosTicketStatus.add(infoFounderAnswer);
        infosTicketStatus.add(infoClosed);
        cols.add(new Col(null, "ticketStatus", "تیکت ها", Type.OBJECT, 550, true, true, infosTicketStatus,false, Icon.none, false));

        cols.add(new Col(null, "received", "دریافتی", Type.ROUTER, 70, true, true,false, Icon.none, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.ROUTER, 70, true, true,false, Icon.none, false));

//        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
//        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
//        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
//        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
//        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));

        return new Meta(cols);
    }

    default Meta meta1() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "departmentID", "departmentID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "departmentName", "عنوان", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "owners", "سرپرستان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "departmentEmailAddress", "آدرس ایمیل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "isVisibleForCustomers", "قابل مشاهده برای مشتریان", Type.BOOLEAN, 170, true, true, false));
        cols.add(new Col(null, "ticketTimeout", "مهلت پیش فرض بسته شدن تیکت", Type.DECIMAL, 230, true, true, false));
        cols.add(new Col(null, "open", "باز", Type.DECIMAL, 50, true, true, false));
        cols.add(new Col(null, "inProgress", "در حال بررسی", Type.DECIMAL, 130, true, true, false));
        cols.add(new Col(null, "answered", "پاسخ داده شده", Type.DECIMAL, 130, true, true, false));
        cols.add(new Col(null, "founderAnswer", "پاسخ ایجاد کننده تیکت", Type.DECIMAL, 200, true, true, false));
        cols.add(new Col(null, "closed", "بسته شده", Type.DECIMAL, 95, true, true, false));
        cols.add(new Col(null, "received", "دریافتی", Type.DECIMAL, 75, true, true, false));
        cols.add(new Col(null, "sent", "ارسالی", Type.DECIMAL, 75, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));

        return new Meta(cols);
    }
}
