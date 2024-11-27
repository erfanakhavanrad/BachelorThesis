package com.tarazgroup.tws.dao.crm;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmEvent;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CrmEventRepository extends TCrudRepository<CrmEvent>, CrudRepository<CrmEvent, BigDecimal> {

    default List<CrmEvent> crmShowEvent(CrmEvent crmEvent) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEvent._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEvent._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEvent._pageFilter()));
        return showSP("CrmShowEvent", tParameters, true);
    }

    default CrmEvent crmShowEventByID(BigDecimal eventID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.eventID=" + eventID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowEvent", tParameters, true).get(0);
    }

    default CrmEvent crmInsEvent(CrmEvent crmEvent) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ReferID", crmEvent.getReferID()));
        tParameters.add(new TParameter<>("FormID", crmEvent.getFormID()));
        tParameters.add(new TParameter<>("IdentityID", crmEvent.getIdentityID()));
        tParameters.add(new TParameter<>("TypeID", crmEvent.getTypeID()));
        tParameters.add(new TParameter<>("StatusID", crmEvent.getStatusID()));
        tParameters.add(new TParameter<>("VoucherTypeID", crmEvent.getVoucherTypeID()));
        tParameters.add(new TParameter<>("PriorityID", crmEvent.getPriorityID()));
        tParameters.add(new TParameter<>("ReferToBaseUserID", logLogins.getPubUser().getUserID()));//در حالت اینزرت  هر ایونت به خود شخص ارجاع داده میشود
        tParameters.add(new TParameter<>("LocationID", crmEvent.getLocationID()));
        tParameters.add(new TParameter<>("EventSubject", crmEvent.getEventSubject()));
        tParameters.add(new TParameter<>("EventDesc", crmEvent.getEventDesc()));
        tParameters.add(new TParameter<>("StartDateG", new TCalendar().getGregorianDateTimeBySlashZero(crmEvent.getStartDate(), crmEvent.getStartTime())));
        tParameters.add(new TParameter<>("EndDateG", new TCalendar().getGregorianDateTimeBySlashZero(crmEvent.getEndDate(), crmEvent.getEndTime())));
        tParameters.add(new TParameter<>("AlarmDateBeforeG", crmEvent.getAlarmDateBeforeG()));
        tParameters.add(new TParameter<>("RelatedUserIDs", crmEvent.getRelatedUserIDs()));
        tParameters.add(new TParameter<>("AudienceIDs", crmEvent.getAudienceIDs()));
        tParameters.add(new TParameter<>("IsAlarm", crmEvent.getIsAlarm()));
        tParameters.add(new TParameter<>("IsPublic", crmEvent.getIsPublic()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsEvent", tParameters);
        return crmShowEventByID(newID);
    }

    default CrmEvent crmUpdEvent(BigDecimal eventID, CrmEvent crmEvent) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("EventID", eventID));
        tParameters.add(new TParameter<>("TypeID", crmEvent.getTypeID()));
        tParameters.add(new TParameter<>("StatusID", crmEvent.getStatusID()));
        tParameters.add(new TParameter<>("PriorityID", crmEvent.getPriorityID()));
        tParameters.add(new TParameter<>("ReferToBaseUserID", crmEvent.getReferToBaseUserID()));
        tParameters.add(new TParameter<>("LocationID", crmEvent.getLocationID()));
        tParameters.add(new TParameter<>("EventSubject", crmEvent.getEventSubject()));
        tParameters.add(new TParameter<>("EventDesc", crmEvent.getEventDesc()));
        tParameters.add(new TParameter<>("StartDateG", new TCalendar().getGregorianDateTimeBySlashZero(crmEvent.getStartDate(), crmEvent.getStartTime())));
        tParameters.add(new TParameter<>("EndDateG", new TCalendar().getGregorianDateTimeBySlashZero(crmEvent.getEndDate(), crmEvent.getEndTime())));
        tParameters.add(new TParameter<>("AlarmDateBeforeG", crmEvent.getAlarmDateBeforeG()));
        tParameters.add(new TParameter<>("RelatedUserIDs", crmEvent.getRelatedUserIDs()));
        tParameters.add(new TParameter<>("AudienceIDs", crmEvent.getAudienceIDs()));
        tParameters.add(new TParameter<>("IsAlarm", crmEvent.getIsAlarm()));
        tParameters.add(new TParameter<>("IsPublic", crmEvent.getIsPublic()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdEvent", tParameters);
        return crmShowEventByID(eventID);
    }

    default CrmEvent crmUpdReferToBaseUserID(BigDecimal eventID, BigDecimal referID) {
        // تنها فیلد ارجاع به آپدیت میشود
        LogLogins logLogins = fetchUserDetail();
        CrmEvent crmEvent = crmShowEventByID(eventID);
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("EventID", eventID));
        tParameters.add(new TParameter<>("TypeID", crmEvent.getTypeID()));
        tParameters.add(new TParameter<>("StatusID", crmEvent.getStatusID()));
        tParameters.add(new TParameter<>("PriorityID", crmEvent.getPriorityID()));
        tParameters.add(new TParameter<>("ReferToBaseUserID", referID));
        tParameters.add(new TParameter<>("LocationID", crmEvent.getLocationID()));
        tParameters.add(new TParameter<>("EventSubject", crmEvent.getEventSubject()));
        tParameters.add(new TParameter<>("EventDesc", crmEvent.getEventDesc()));
        tParameters.add(new TParameter<>("StartDateG", crmEvent.getStartDateG()));
        tParameters.add(new TParameter<>("EndDateG", crmEvent.getEndDateG()));
        tParameters.add(new TParameter<>("AlarmDateBeforeG", crmEvent.getAlarmDateBeforeG()));
        tParameters.add(new TParameter<>("RelatedUserIDs", crmEvent.getRelatedUserIDs()));
        tParameters.add(new TParameter<>("AudienceIDs", crmEvent.getAudienceIDs()));
        tParameters.add(new TParameter<>("IsAlarm", crmEvent.getIsAlarm()));
        tParameters.add(new TParameter<>("IsPublic", crmEvent.getIsPublic()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdEvent", tParameters);
        return crmShowEventByID(eventID);
    }

    default void crmDelEvent(BigDecimal eventID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("EventID", eventID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelEvent", tParameters);
    }

    default InputStreamResource excel(CrmEvent crmEvent) {
        List<TParameter<?>> tParameters = new ArrayList<>();

        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEvent._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEvent._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEvent._pageFilter()));
        List<CrmEvent> rows = showSP("CrmShowEvent", tParameters, false);
        return exportToExcel(rows, metaEvent().getCols(), "فرم ها");
    }

    default Meta metaEvent() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "eventID", "eventID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "referID", "referID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "formID", "formID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "identityID", "identityID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "typeID", "typeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "statusID", "statusID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "voucherTypeID", "voucherTypeID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "priorityID", "priorityID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "referToBaseUserID", "referToBaseUserID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "locationID", "locationID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "eventSubject", "موضوع رویداد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "eventDesc", "شرح رویداد", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "startDateG", "startDateG", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "endDateG", "endDateG", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "alarmDateBeforeG", "alarmDateBeforeG", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "relatedUserIDs", "relatedUserIDs", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "audienceIDs", "audienceIDs", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "isAlarm", "آلارم", Type.BOOLEAN, 100, false, true, false));
        cols.add(new Col(null, "isPublic", "عمومی", Type.BOOLEAN, 100, false, true, false));
        cols.add(new Col(null, "referDesc", "referDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "referCode", "referCode", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "identityDesc", "identityDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "identityLatinDesc", "identityLatinDesc", Type.STRING, 0, false, false, false));
        cols.add(new Col(null, "typeDesc", "نوع رویداد", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "statusDesc", "شرح وضعیت", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "statusColor", "رنگ وضعیت", Type.COLOR, 100, false, true, false));
        cols.add(new Col(null, "customVTypeDesc", "نوع", Type.STRING, 100, false, true, false));
        cols.add(new Col(null, "priorityCode", "کد اولویت", Type.STRING, 100, false, true, false));
        cols.add(new Col(null, "priorityDesc", "شرح اولویت", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "priorityColor", "رنگ اولویت", Type.COLOR, 100, false, true, false));
        cols.add(new Col(null, "referToBaseUserName", "ارجاع به", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "locationDesc", "محل برگزاری", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "startDate", "تاریخ آغاز", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "endDate", "تاریخ پایان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "startTime", "زمان آغاز", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "endTime", "زمان پایان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "alarmDateBefore", "آغاز آلارم از تاریخ", Type.STRING, 200, true, false, false));
        cols.add(new Col(null, "alarmTimeBefore", "آغاز آلارم از زمان", Type.STRING, 200, true, false, false));
        cols.add(new Col(null, "relatedUserNames", "کاربران مرتبط شرکت ما", Type.STRING, 250, true, false, false));
        cols.add(new Col(null, "audienceNames", "پرسنل مرتبط طرف مقابل", Type.STRING, 250, true, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.INTEGER, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 100, false, false, false));
        cols.add(new Col(null, "creatorName", "ایجاد کننده", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "modifierName", "ویرایش کننده", Type.STRING, 100, true, false, false));
        return new Meta(cols);
    }
}
