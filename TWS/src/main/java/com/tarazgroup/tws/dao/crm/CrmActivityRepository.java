package com.tarazgroup.tws.dao.crm;

/***
 * @author A.Farahani
 * @date Feb-07, 2023
 ***/

import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmActivity;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface CrmActivityRepository extends TCrudRepository<CrmActivity>, CrudRepository<CrmActivity, BigDecimal> {

    default List<CrmActivity> crmShowActivity(CrmActivity crmActivity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivity._pageFilter()));
        return showSP("CrmShowActivity", tParameters, true);
    }


    default List<CrmActivity> crmShowActivityByForm(CrmActivity crmActivity, BigDecimal formID, BigDecimal recordID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", "AND Main.FormID = " + formID + " AND Main.RecordID = " + recordID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivity._pageFilter()));
        return showSP("CrmShowActivity", tParameters, true);
    }

    default CrmActivity crmShowActivityByID(BigDecimal activityID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND main.ActivityID=" + activityID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowActivity", tParameters, true).get(0);
    }

    default List<CrmActivity> crmShowTasks(CrmActivity crmTask, BigDecimal formID, BigDecimal recordID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND Main.IdentityID = 1 AND Main.FormID = " + formID + " AND Main.RecordID = " + recordID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmTask._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmTask._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmTask._pageFilter()));
        return showSP("CrmShowActivity", tParameters, true);
    }

    default List<CrmActivity> crmShowEvents(CrmActivity crmEvent, BigDecimal formID, BigDecimal recordID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND Main.IdentityID = 2 AND Main.FormID = " + formID + " AND Main.RecordID = " + recordID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEvent._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEvent._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEvent._pageFilter()));
        return showSP("CrmShowActivity", tParameters, true);
    }

    default CrmActivity crmShowTaskByID(BigDecimal activityID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("Filter", " AND main.ActivityID=" + activityID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowActivity", tParameters, true).get(0);
    }

//    default CrmActivity crmInsActivity(CrmActivity crmActivity) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("ReferID", crmActivity.getReferID()));
//        tParameters.add(new TParameter<>("FormID", crmActivity.getFormID()));
//        tParameters.add(new TParameter<>("RecordID", crmActivity.getRecordID()));
//        tParameters.add(new TParameter<>("IdentityID", crmActivity.getIdentityID()));
//        tParameters.add(new TParameter<>("TypeID", crmActivity.getTypeID()));
//        tParameters.add(new TParameter<>("StatusID", crmActivity.getStatusID()));
//        tParameters.add(new TParameter<>("VoucherTypeID", crmActivity.getVoucherTypeID()));
//        tParameters.add(new TParameter<>("PriorityID", crmActivity.getPriorityID()));
//        tParameters.add(new TParameter<>("ReferToBaseUserID", logLogins.getPubUser().getUserID()));//در حالت اینزرت  هر ایونت به خود شخص ارجاع داده میشود
//        tParameters.add(new TParameter<>("LocationID", crmActivity.getLocationID()));
//        tParameters.add(new TParameter<>("ActivityName", crmActivity.getActivityName()));
//        tParameters.add(new TParameter<>("ActivityDesc", crmActivity.getActivityDesc()));
//        tParameters.add(new TParameter<>("StartDateG", new TCalendar().getGregorianDateTimeBySlashZero(crmActivity.getStartDate(), crmActivity.getStartTime())));
//        tParameters.add(new TParameter<>("EndDateG", new TCalendar().getGregorianDateTimeBySlashZero(crmActivity.getEndDate(), crmActivity.getEndTime())));
//        tParameters.add(new TParameter<>("AlarmDateBeforeG", crmActivity.getAlarmDateBeforeG()));
//        tParameters.add(new TParameter<>("RelatedUserIDs", crmActivity.getRelatedUserIDs()));
//        tParameters.add(new TParameter<>("AudienceIDs", crmActivity.getAudienceIDs()));
//        tParameters.add(new TParameter<>("IsAlarm", crmActivity.getIsAlarm()));
//        tParameters.add(new TParameter<>("IsPublic", crmActivity.getIsPublic()));
//        tParameters.add(new TParameter<>("HasAnnouncement", crmActivity.getHasAnnouncement()));
//        tParameters.add(new TParameter<>("HasReminder", crmActivity.getHasReminder()));
//        tParameters.add(new TParameter<>("HasRepeat", crmActivity.getHasRepeat()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("CrmInsActivity", tParameters);
//        return crmShowActivityByID(newID);
//    }

    default CrmActivity crmInsTask(CrmActivity crmTask, BigDecimal formID, BigDecimal recordID) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("IdentityID", BigDecimal.valueOf(1)));
        tParameters.add(new TParameter<>("ActivityName", crmTask.getActivityName()));
        if (crmTask.getStartDate() == null) {
            tParameters.add(new TParameter<>("StartDateG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmTask.getStartDate());
            tParameters.add(new TParameter<>("StartDateG", tCalendar.getGregorianDate()));
        }
        if (crmTask.getStartTime() == null) {
            tParameters.add(new TParameter<>("StartTime", "00:00:00"));
        } else {
        tParameters.add(new TParameter<>("StartTime", crmTask.getStartTime()));
        }
        tParameters.add(new TParameter<>("TypeID", crmTask.getTypeID()));
        tParameters.add(new TParameter<>("ReferID", crmTask.getReferID()));
        if (crmTask.getEndDate() == null) {
            tParameters.add(new TParameter<>("EndDateG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmTask.getEndDate());
            tParameters.add(new TParameter<>("EndDateG", tCalendar.getGregorianDate()));
        }
        if (crmTask.getEndTime() == null) {
            tParameters.add(new TParameter<>("EndTime", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("EndTime", crmTask.getEndTime()));
        }
        tParameters.add(new TParameter<>("HasAnnouncement", crmTask.getHasAnnouncement()));
        tParameters.add(new TParameter<>("StatusID", crmTask.getStatusID()));
        tParameters.add(new TParameter<>("PriorityID", crmTask.getPriorityID()));
        tParameters.add(new TParameter<>("HasReminder", crmTask.getHasReminder()));
        if (crmTask.getAlarmDateBefore() == null) {
            tParameters.add(new TParameter<>("AlarmDateBeforeG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmTask.getAlarmDateBefore());
            tParameters.add(new TParameter<>("AlarmDateBeforeG", tCalendar.getGregorianDate()));
        }
        if (crmTask.getAlarmTimeBefore() == null) {
            tParameters.add(new TParameter<>("AlarmTimeBefore", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("AlarmTimeBefore", crmTask.getAlarmTimeBefore()));
        }
        tParameters.add(new TParameter<>("LocationID", crmTask.getLocationID()));
        tParameters.add(new TParameter<>("HasRepeat", crmTask.getHasRepeat()));
        tParameters.add(new TParameter<>("RepeatDay", crmTask.getRepeatDay()));
        tParameters.add(new TParameter<>("RepeatTime", crmTask.getRepeatTime()));
        if (crmTask.getRepeatDateUntil() == null) {
            tParameters.add(new TParameter<>("RepeatDateUntilG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmTask.getRepeatDateUntil());
            tParameters.add(new TParameter<>("RepeatDateUntilG", tCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("IsPublic", null));
        tParameters.add(new TParameter<>("ActivityDesc", crmTask.getActivityDesc()));
        tParameters.add(new TParameter<>("ReferToBaseUserID", logLogins.getPubUser().getUserID()));//در حالت اینسرت هر ایونت به خود شخص ارجاع داده میشود
        tParameters.add(new TParameter<>("RelatedUserIDs", null));
//        tParameters.add(new TParameter<>("VoucherTypeID", null));
//        tParameters.add(new TParameter<>("AudienceIDs", null));
//        tParameters.add(new TParameter<>("IsAlarm", null));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsActivity", tParameters);
        return crmShowActivityByID(newID);
    }

    default CrmActivity crmInsEvent(CrmActivity crmActivity, BigDecimal formID, BigDecimal recordID) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FormID", formID));
        tParameters.add(new TParameter<>("RecordID", recordID));
        tParameters.add(new TParameter<>("IdentityID", BigDecimal.valueOf(2)));
        tParameters.add(new TParameter<>("ActivityName", crmActivity.getActivityName()));
        if (crmActivity.getStartDate() == null) {
            tParameters.add(new TParameter<>("StartDateG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getStartDate());
            tParameters.add(new TParameter<>("StartDateG", tCalendar.getGregorianDate()));
        }
        if (crmActivity.getStartTime() == null) {
            tParameters.add(new TParameter<>("StartTime", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("StartTime", crmActivity.getStartTime()));
        }
        tParameters.add(new TParameter<>("TypeID", crmActivity.getTypeID()));
        tParameters.add(new TParameter<>("ReferID", crmActivity.getReferID()));
        if (crmActivity.getEndDate() == null) {
            tParameters.add(new TParameter<>("EndDateG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getEndDate());
            tParameters.add(new TParameter<>("EndDateG", tCalendar.getGregorianDate()));
        }
        if (crmActivity.getEndTime() == null) {
            tParameters.add(new TParameter<>("EndTime", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("EndTime", crmActivity.getEndTime()));
        }
        tParameters.add(new TParameter<>("HasAnnouncement", crmActivity.getHasAnnouncement()));
        tParameters.add(new TParameter<>("StatusID", crmActivity.getStatusID()));
        tParameters.add(new TParameter<>("PriorityID", crmActivity.getPriorityID()));
        tParameters.add(new TParameter<>("HasReminder", crmActivity.getHasReminder()));
        if (crmActivity.getAlarmDateBefore() == null) {
            tParameters.add(new TParameter<>("AlarmDateBeforeG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getAlarmDateBefore());
            tParameters.add(new TParameter<>("AlarmDateBeforeG", tCalendar.getGregorianDate()));
        }
        if (crmActivity.getAlarmTimeBefore() == null) {
            tParameters.add(new TParameter<>("AlarmTimeBefore", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("AlarmTimeBefore", crmActivity.getAlarmTimeBefore()));
        }
        tParameters.add(new TParameter<>("LocationID", crmActivity.getLocationID()));
        tParameters.add(new TParameter<>("HasRepeat", crmActivity.getHasRepeat()));
        tParameters.add(new TParameter<>("RepeatDay", crmActivity.getRepeatDay()));
        tParameters.add(new TParameter<>("RepeatTime", crmActivity.getRepeatTime()));
        if (crmActivity.getRepeatDateUntil() == null) {
            tParameters.add(new TParameter<>("RepeatDateUntilG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getRepeatDateUntil());
            tParameters.add(new TParameter<>("RepeatDateUntilG", tCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("IsPublic", crmActivity.getIsPublic()));
        tParameters.add(new TParameter<>("ActivityDesc", crmActivity.getActivityDesc()));
        tParameters.add(new TParameter<>("ReferToBaseUserID", logLogins.getPubUser().getUserID()));//در حالت اینسرت هر ایونت به خود شخص ارجاع داده میشود
        tParameters.add(new TParameter<>("RelatedUserIDs", crmActivity.getRelatedUserIDs()));
//        tParameters.add(new TParameter<>("VoucherTypeID", null));
//        tParameters.add(new TParameter<>("AudienceIDs", null));
//        tParameters.add(new TParameter<>("IsAlarm", null));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsActivity", tParameters);
        return crmShowActivityByID(newID);
    }

    default CrmActivity crmUpdActivity(BigDecimal activityID, CrmActivity crmActivity) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActivityID", activityID));
        tParameters.add(new TParameter<>("TypeID", crmActivity.getTypeID()));
        tParameters.add(new TParameter<>("StatusID", crmActivity.getStatusID()));
        tParameters.add(new TParameter<>("PriorityID", crmActivity.getPriorityID()));
        tParameters.add(new TParameter<>("ReferID", crmActivity.getReferID()));
        tParameters.add(new TParameter<>("LocationID", crmActivity.getLocationID()));
        tParameters.add(new TParameter<>("ActivityName", crmActivity.getActivityName()));
        tParameters.add(new TParameter<>("ActivityDesc", crmActivity.getActivityDesc()));
        if (crmActivity.getStartDate() == null) {
            tParameters.add(new TParameter<>("StartDateG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getStartDate());
            tParameters.add(new TParameter<>("StartDateG", tCalendar.getGregorianDate()));
        }
        if (crmActivity.getStartTime() == null) {
            tParameters.add(new TParameter<>("StartTime", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("StartTime", crmActivity.getStartTime()));
        }
        if (crmActivity.getEndDate() == null) {
            tParameters.add(new TParameter<>("EndDateG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getEndDate());
            tParameters.add(new TParameter<>("EndDateG", tCalendar.getGregorianDate()));
        }
        if (crmActivity.getEndTime() == null) {
            tParameters.add(new TParameter<>("EndTime", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("EndTime", crmActivity.getEndTime()));
        }
        if (crmActivity.getAlarmDateBefore() == null) {
            tParameters.add(new TParameter<>("AlarmDateBeforeG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getAlarmDateBefore());
            tParameters.add(new TParameter<>("AlarmDateBeforeG", tCalendar.getGregorianDate()));
        }
        if (crmActivity.getAlarmTimeBefore() == null) {
            tParameters.add(new TParameter<>("AlarmTimeBefore", "00:00:00"));
        } else {
            tParameters.add(new TParameter<>("AlarmTimeBefore", crmActivity.getAlarmTimeBefore()));
        }
        tParameters.add(new TParameter<>("RelatedUserIDs", crmActivity.getRelatedUserIDs()));
//        tParameters.add(new TParameter<>("AudienceIDs", crmActivity.getAudienceIDs()));
//        tParameters.add(new TParameter<>("IsAlarm", crmActivity.getIsAlarm()));
        tParameters.add(new TParameter<>("IsPublic", crmActivity.getIsPublic()));
        tParameters.add(new TParameter<>("HasAnnouncement", crmActivity.getHasAnnouncement()));
        tParameters.add(new TParameter<>("HasReminder", crmActivity.getHasReminder()));
        tParameters.add(new TParameter<>("HasRepeat", crmActivity.getHasRepeat()));
        tParameters.add(new TParameter<>("RepeatDay", crmActivity.getRepeatDay()));
        tParameters.add(new TParameter<>("RepeatTime", crmActivity.getRepeatTime()));
        if (crmActivity.getRepeatDateUntil() == null) {
            tParameters.add(new TParameter<>("RepeatDateUntilG", null));
        } else {
            tCalendar.setIranianDateBySlash(crmActivity.getRepeatDateUntil());
            tParameters.add(new TParameter<>("RepeatDateUntilG", tCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdActivity", tParameters);
        return crmShowActivityByID(activityID);
    }

//    default CrmActivity crmUpdReferToBaseUserID(BigDecimal activityID, BigDecimal referID) {
//        // تنها فیلد ارجاع به آپدیت میشود
//        LogLogins logLogins = fetchUserDetail();
//        CrmActivity crmActivity = crmShowActivityByID(activityID);
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("ActivityID", activityID));
//        tParameters.add(new TParameter<>("TypeID", crmActivity.getTypeID()));
//        tParameters.add(new TParameter<>("StatusID", crmActivity.getStatusID()));
//        tParameters.add(new TParameter<>("PriorityID", crmActivity.getPriorityID()));
//        tParameters.add(new TParameter<>("ReferToBaseUserID", referID));
//        tParameters.add(new TParameter<>("LocationID", crmActivity.getLocationID()));
//        tParameters.add(new TParameter<>("ActivityName", crmActivity.getActivityName()));
//        tParameters.add(new TParameter<>("ActivityDesc", crmActivity.getActivityDesc()));
//        tParameters.add(new TParameter<>("StartDateG", crmActivity.getStartDateG()));
//        tParameters.add(new TParameter<>("EndDateG", crmActivity.getEndDateG()));
//        tParameters.add(new TParameter<>("AlarmDateBeforeG", crmActivity.getAlarmDateBeforeG()));
//        tParameters.add(new TParameter<>("RelatedUserIDs", crmActivity.getRelatedUserIDs()));
//        tParameters.add(new TParameter<>("AudienceIDs", crmActivity.getAudienceIDs()));
//        tParameters.add(new TParameter<>("IsAlarm", crmActivity.getIsAlarm()));
//        tParameters.add(new TParameter<>("IsPublic", crmActivity.getIsPublic()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        updSP("CrmUpdActivity", tParameters);
//        return crmShowActivityByID(activityID);
//    }

    default void crmDelActivity(BigDecimal activityID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ActivityID", activityID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelActivity", tParameters);
    }

    default InputStreamResource excel(CrmActivity crmActivity) {
        List<TParameter<?>> tParameters = new ArrayList<>();

        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivity._pageFilter()));
        List<CrmActivity> rows = showSP("CrmShowActivity", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "activityID", "activityID", Type.DECIMAL, false, 0, false, false, true));
        cols.add(new Col(null, "activityName", "موضوع", Type.STRING, true, 100, true, true, false));
        cols.add(new Col(null, "referToBaseUserID", "referToBaseUserID", Type.DECIMAL, false, 0, false, false, false));
        cols.add(new Col(null, "activityDesc", "شرح رویداد", Type.STRING, false, 100, true, true, false));
        cols.add(new Col(null, "relatedUserIDs", "relatedUserIDs", Type.STRING, false, 0, false, false, false));
        cols.add(new Col(null, "audienceIDs", "audienceIDs", Type.STRING, false, 0, false, false, false));
        cols.add(new Col(null, "isAlarm", "آلارم", Type.BOOLEAN, false, 100, false, true, false));
        cols.add(new Col(null, "isPublic", "عمومی", Type.BOOLEAN, false, 100, false, false, false));
        cols.add(new Col(null, "hasAnnouncement", "اطلاع رسانی", Type.BOOLEAN, false, 100, true, true, false));
        cols.add(new Col(null, "hasReminder", "یادآوری", Type.BOOLEAN, false, 100, true, true, false));
        cols.add(new Col(null, "hasRepeat", "تکرار", Type.BOOLEAN, false, 100, true, true, false));
        cols.add(new Col(null, "referDesc", "ارجاع به", Type.STRING, false, 0, true, true, false));
        cols.add(new Col(null, "identityDesc", "نوع فعالیت", Type.STRING, false, 100, true, false, false));
        cols.add(new Col(null, "identityLatinDesc", "identityLatinDesc", Type.STRING, false, 0, false, false, false));
        cols.add(new Col(null, "typeDesc", "نوع", Type.STRING, false, 150, true, true, false));
        cols.add(new Col(null, "typeIcon", "typeIcon", Type.STRING, false, 150, false, true, false));
        cols.add(new Col(null, "statusTitle", "وضعیت", Type.STRING, false, 150, true, true, false));
        cols.add(new Col(null, "statusColor", "statusColor", Type.COLOR, false, 100, false, true, false));
        cols.add(new Col(null, "priorityName", "اهمیت", Type.STRING, false, 100, true, true, false));
        cols.add(new Col(null, "priorityColor", "رنگ اولویت", Type.COLOR, false, 100, false, true, false));
        cols.add(new Col(null, "referToBaseUserName", "ارجاع به", Type.STRING, false, 100, false, true, false));
        cols.add(new Col(null, "locationDesc", "محل برگزاری", Type.STRING, false, 100, true, true, false));
        cols.add(new Col(null, "startDate", "تاریخ آغاز", Type.DATE, true, 100, true, true, false));
        cols.add(new Col(null, "endDate", "تاریخ پایان", Type.DATE, true, 100, true, true, false));
        cols.add(new Col(null, "startTime", "زمان آغاز", Type.TIME, true, 100, true, true, false));
        cols.add(new Col(null, "endTime", "زمان پایان", Type.TIME, true, 100, true, true, false));
        cols.add(new Col(null, "alarmDateBefore", "یادآوری تاریخ", Type.STRING, false, 200, false, false, false));
        cols.add(new Col(null, "alarmTimeBefore", "آغاز آلارم از زمان", Type.STRING, false, 200, false, false, false));
        cols.add(new Col(null, "relatedUserNames", "کاربران مرتبط با فعالیت", Type.STRING, false, 250, true, false, false));
        cols.add(new Col(null, "audienceNames", "پرسنل مرتبط طرف مقابل", Type.STRING, false, 250, false, false, false));
        cols.add(new Col(null, "typeID", "نوع", Type.TLOOKUP, true, "crm/eventtypes", "crm/eventtypes/meta", "typeDesc", 0, false, false, false));
        cols.add(new Col(null, "priorityID", "اهمیت", Type.TLOOKUP, true, "tkt/priorities", "tkt/priorities/meta", "priorityName", 0, false, false, false));
        cols.add(new Col(null, "statusID", "وضعیت", Type.TLOOKUP, true, "crm/status", "crm/status/meta", "statusTitle", 0, false, false, false));
        cols.add(new Col(null, "locationID", "محل", Type.TLOOKUP, false, "crm/activitylocations", "crm/activitylocations/meta", "locationDesc", 0, false, false, false));
        cols.add(new Col(null, "referID", "ارجاع به", Type.TLOOKUP, true, "crm/users", "crm/users/meta", "perComName", 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, false, 100, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, false, 100, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, false, 100, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, false, 120, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, false, 100, false, false, false));
        return new Meta(cols);
    }
}

